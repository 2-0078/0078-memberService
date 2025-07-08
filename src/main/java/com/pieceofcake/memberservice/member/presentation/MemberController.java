package com.pieceofcake.memberservice.member.presentation;

import com.pieceofcake.memberservice.member.application.MemberService;
import com.pieceofcake.memberservice.member.dto.in.*;
import com.pieceofcake.memberservice.member.vo.in.*;
import com.pieceofcake.memberservice.member.vo.out.*;
import com.pieceofcake.memberservice.common.entity.BaseResponseEntity;
import com.pieceofcake.memberservice.common.entity.BaseResponseStatus;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @Operation(
            summary = "이메일 중복 확인",
            description = "이메일이 이미 사용 중인지 확인합니다."
    )
    @GetMapping("/check-email")
    public BaseResponseEntity<CheckEmailResponseVo> checkEmail(
            @RequestParam("email") String email
    ) {
        return new BaseResponseEntity<> (
                memberService.checkEmail(CheckEmailRequestDto.of(email)).toVo()
        );
    }

    @Operation(
            summary = "닉네임 중복 확인",
            description = "닉네임이 이미 사용 중인지 확인합니다."
    )
    @GetMapping("/check-nickname")
    public BaseResponseEntity<CheckNicknameResponseVo> checkNickname(
            @RequestParam("nickname") String nickname
    ) {
        return new BaseResponseEntity<>(
                memberService.checkNickname(CheckNicknameRequestDto.of(nickname)).toVo()
        );
    }

    @Operation(
            summary = "전화번호 중복 확인",
            description = "phoneNumber를 통해 이미 등록된 전화번호인지 확인합니다. " +
                    "response body에는 available 이 포함됩니다."
    )
    @GetMapping("/check-phone-number")
    public BaseResponseEntity<CheckPhoneNumberResponseVo> checkPhoneNumber(
            @RequestParam("phoneNumber") String phoneNumber
    ) {
        return new BaseResponseEntity<>(
                memberService.checkPhoneNumber(CheckPhoneNumberRequestDto.of(phoneNumber)).toVo()
        );
    }

    @Operation(
            summary = "이메일 찾기",
            description = "이름과 전화번호를 통해 사용자의 이메일을 찾습니다."
    )
    @GetMapping("/find-email")
    public BaseResponseEntity<FindEmailResponseVo> findEmail(
            @ModelAttribute FindEmailRequestVo findEmailRequestVo
    ) {
        return new BaseResponseEntity<>(
                memberService.findEmail(FindEmailRequestDto.from(findEmailRequestVo)).toVo()
        );
    }

    @Operation(
            summary = "회원 정보 수정",
            description = "회원의 닉네임, 프로필이미지를 업데이트합니다."
    )
    @PutMapping("")
    public BaseResponseEntity<Void> updateMember(
            @RequestHeader(value = "X-Member-Uuid") String memberUuid,
            @RequestBody @Valid UpdateMemberRequestVo updateMemberRequestVo
    ) {
        memberService.updateMember(UpdateMemberRequestDto.of(memberUuid, updateMemberRequestVo));
        return new BaseResponseEntity<>(BaseResponseStatus.MEMBER_UPDATE_SUCCESS);
    }

    @Operation(
            summary = "회원 정보 조회",
            description = "회원의 프로필 정보를 조회합니다."
    )
    @GetMapping("")
    public BaseResponseEntity<ReadMemberResponseVo> readMember(
            @RequestHeader(value = "X-Member-Uuid") String memberUuid
    ) {
        ReadMemberRequestVo readMemberRequestVo = ReadMemberRequestVo.builder()
                .memberUuid(memberUuid)
                .build();

        return new BaseResponseEntity<>(
                memberService.readMember(ReadMemberRequestDto.from(readMemberRequestVo)).toVo()
        );
    }

    @Operation(
            summary = "프로필 이미지 조회",
            description = "memberUuid를 통해 프로필 이미지를 조회합니다. " +
                    "response body에는 profile_image_url, nickname 이 포함됩니다."
    )
    @GetMapping("/profile-image")
    public BaseResponseEntity<ReadProfileImageResponseVo> readProfileImage(
            @RequestParam("memberUuid") String memberUuid
    ) {
        ReadProfileImageRequestVo readProfileImageRequestVo = ReadProfileImageRequestVo.builder()
                .memberUuid(memberUuid)
                .build();

        return new BaseResponseEntity<>(
                memberService.readProfileImage(ReadProfileImageRequestDto.from(readProfileImageRequestVo)).toVo()
        );
    }

    @Operation(
            summary = "프로필 이미지 업로드",
            description = "프로필 이미지를 업로드합니다. "
    )
    @PostMapping("/profile-image")
    public BaseResponseEntity<Void> uploadProfileImage(
            @RequestHeader(value = "X-Member-Uuid") String memberUuid,
            @RequestBody UploadProfileImageRequestVo uploadProfileImageRequestVo
    ) {
        memberService.uploadProfileImage(UploadProfileImageRequestDto.from(uploadProfileImageRequestVo, memberUuid));

        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }



}
