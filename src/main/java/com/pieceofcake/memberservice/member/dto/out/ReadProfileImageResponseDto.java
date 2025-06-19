package com.pieceofcake.memberservice.member.dto.out;

import com.pieceofcake.memberservice.member.entity.Member;
import com.pieceofcake.memberservice.member.vo.in.ReadProfileImageRequestVo;
import com.pieceofcake.memberservice.member.vo.out.ReadProfileImageResponseVo;
import lombok.Builder;

public class ReadProfileImageResponseDto {
    private String profileImageUrl;

    @Builder
    public ReadProfileImageResponseDto(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public static ReadProfileImageResponseDto from(Member member) {
        return ReadProfileImageResponseDto.builder()
                .profileImageUrl(member.getProfileImageUrl())
                .build();
    }

    public ReadProfileImageResponseVo toVo() {
        return ReadProfileImageResponseVo.builder()
                .profileImageUrl(profileImageUrl)
                .build();
    }
}
