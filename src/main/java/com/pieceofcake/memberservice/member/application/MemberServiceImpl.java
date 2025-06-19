package com.pieceofcake.memberservice.member.application;

import com.pieceofcake.memberservice.common.entity.BaseResponseStatus;
import com.pieceofcake.memberservice.common.exception.BaseException;
import com.pieceofcake.memberservice.common.util.RedisUtil;
import com.pieceofcake.memberservice.member.dto.in.*;
import com.pieceofcake.memberservice.member.dto.out.*;
import com.pieceofcake.memberservice.member.entity.Member;
import com.pieceofcake.memberservice.member.infrastructure.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final RedisUtil redisUtil;

    @Override
    public void createMember(CreateMemberDto createMemberDto) {
        // 중복 확인
        if (memberRepository.existsByEmail(createMemberDto.getEmail())) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_EMAIL);
        }

        memberRepository.save(createMemberDto.toEntity());
    }

    @Override
    public CheckEmailResponseDto checkEmail(CheckEmailRequestDto checkEmailRequestDto) {
        boolean available = !memberRepository.existsByEmail(checkEmailRequestDto.getEmail());

        return CheckEmailResponseDto.of(available);
    }

    @Override
    public CheckNicknameResponseDto checkNickname(CheckNicknameRequestDto checkNicknameRequestDto) {
        boolean available = !memberRepository.existsByNickname(checkNicknameRequestDto.getNickname());

        return CheckNicknameResponseDto.of(available);
    }

    @Override
    public FindEmailResponseDto findEmail(FindEmailRequestDto findEmailRequestDto) {

        if (!"true".equals(redisUtil.get("sms:FIND_EMAIL:Verified:" + findEmailRequestDto.getPhoneNumber()))) {
            throw new BaseException(BaseResponseStatus.SMS_VERIFICATION_NOT_COMPLETED);
        }

        Member member = memberRepository.findByPhoneNumberAndName(
                findEmailRequestDto.getPhoneNumber(),
                findEmailRequestDto.getName()
        ).orElseThrow(() -> new BaseException(BaseResponseStatus.MEMBER_NOT_FOUND));

        return FindEmailResponseDto.from(member);
    }

    @Transactional
    @Override
    public void updateMember(UpdateMemberRequestDto updateMemberRequestDto) {

        if (memberRepository.existsByNickname(updateMemberRequestDto.getNickname())) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_NICKNAME);
        }

        Member member = memberRepository.findByMemberUuid(updateMemberRequestDto.getMemberUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.MEMBER_NOT_FOUND));

        memberRepository.save(updateMemberRequestDto.updateEntity(member));
    }

    @Override
    public ReadMemberResponseDto readMember(ReadMemberRequestDto readMemberRequestDto) {
        Member member = memberRepository.findByMemberUuid(readMemberRequestDto.getMemberUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.MEMBER_NOT_FOUND));

        return ReadMemberResponseDto.from(member);
    }

    @Override
    public ReadProfileImageResponseDto readProfileImage(ReadProfileImageRequestDto readProfileImageRequestDto) {
        Member member = memberRepository.findByMemberUuid(readProfileImageRequestDto.getMemberUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.MEMBER_NOT_FOUND));

        return ReadProfileImageResponseDto.from(member);
    }

    @Override
    public void uploadProfileImage(UploadProfileImageRequestDto uploadProfileImageRequestDto) {
        Member member = memberRepository.findByMemberUuid(uploadProfileImageRequestDto.getMemberUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.MEMBER_NOT_FOUND));

        Member newMember = uploadProfileImageRequestDto.updateEntity(member);

        memberRepository.save(newMember);
    }
}
