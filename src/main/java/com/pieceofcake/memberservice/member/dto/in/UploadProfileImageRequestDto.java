package com.pieceofcake.memberservice.member.dto.in;

import com.pieceofcake.memberservice.member.entity.Member;
import com.pieceofcake.memberservice.member.vo.in.UploadProfileImageRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UploadProfileImageRequestDto {

    private String memberUuid;
    private String profileImageUrl;

    @Builder
    public UploadProfileImageRequestDto(String memberUuid, String profileImageUrl) {
        this.memberUuid = memberUuid;
        this.profileImageUrl = profileImageUrl;
    }

    public static UploadProfileImageRequestDto from(UploadProfileImageRequestVo uploadProfileImageRequestVo, String memberUuid) {
        return UploadProfileImageRequestDto.builder()
                .memberUuid(memberUuid)
                .profileImageUrl(uploadProfileImageRequestVo.getProfileImageUrl())
                .build();
    }

    public Member updateEntity(Member member) {
        return Member.builder()
                .id(member.getId())
                .memberUuid(member.getMemberUuid())
                .email(member.getEmail())
                .name(member.getName())
                .phoneNumber(member.getPhoneNumber())
                .birthdate(member.getBirthdate())
                .gender(member.getGender())
                .status(member.getStatus())
                .nickname(member.getNickname())
                .profileImageUrl(this.profileImageUrl)
                .build();
    }
}
