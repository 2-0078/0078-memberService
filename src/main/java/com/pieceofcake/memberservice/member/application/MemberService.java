package com.pieceofcake.memberservice.member.application;

import com.pieceofcake.memberservice.member.dto.in.*;
import com.pieceofcake.memberservice.member.dto.out.*;

public interface MemberService {
    void createMember(CreateMemberDto createMemberDto);
    CheckEmailResponseDto checkEmail(CheckEmailRequestDto checkEmailRequestDto);
    CheckNicknameResponseDto checkNickname(CheckNicknameRequestDto checkNicknameRequestDto);
    FindEmailResponseDto findEmail(FindEmailRequestDto findEmailRequestDto);
    void updateMember(UpdateMemberRequestDto updateMemberRequestDto);
    ReadMemberResponseDto readMember(ReadMemberRequestDto readMemberRequestDto);
    ReadProfileImageResponseDto readProfileImage(ReadProfileImageRequestDto readProfileImageRequestDto);
    void uploadProfileImage(UploadProfileImageRequestDto uploadProfileImageRequestDto);
}
