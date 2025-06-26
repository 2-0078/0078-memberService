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

    @GetMapping("/check-email")
    public BaseResponseEntity<CheckEmailResponseVo> checkEmail(
            @RequestParam("email") String email
    ) {
        return new BaseResponseEntity<> (
                memberService.checkEmail(CheckEmailRequestDto.of(email)).toVo()
        );
    }

    @GetMapping("/check-nickname")
    public BaseResponseEntity<CheckNicknameResponseVo> checkNickname(
            @RequestParam("nickname") String nickname
    ) {
        return new BaseResponseEntity<>(
                memberService.checkNickname(CheckNicknameRequestDto.of(nickname)).toVo()
        );
    }

    @GetMapping("/find-email")
    public BaseResponseEntity<FindEmailResponseVo> findEmail(
            @ModelAttribute FindEmailRequestVo findEmailRequestVo
    ) {
        return new BaseResponseEntity<>(
                memberService.findEmail(FindEmailRequestDto.from(findEmailRequestVo)).toVo()
        );
    }

    @PutMapping("")
    public BaseResponseEntity<Void> updateMember(
            @RequestHeader(value = "X-Member-Uuid") String memberUuid,
            @RequestBody @Valid UpdateMemberRequestVo updateMemberRequestVo
    ) {
        memberService.updateMember(UpdateMemberRequestDto.of(memberUuid, updateMemberRequestVo));
        return new BaseResponseEntity<>(BaseResponseStatus.MEMBER_UPDATE_SUCCESS);
    }

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

    @PostMapping("/profile-image")
    public BaseResponseEntity<Void> uploadProfileImage(
            @RequestHeader(value = "X-Member-Uuid") String memberUuid,
            @RequestBody UploadProfileImageRequestVo uploadProfileImageRequestVo
    ) {
        memberService.uploadProfileImage(UploadProfileImageRequestDto.from(uploadProfileImageRequestVo, memberUuid));

        return new BaseResponseEntity<>(BaseResponseStatus.SUCCESS);
    }

}
