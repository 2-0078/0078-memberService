package com.pieceofcake.memberservice.member.dto.out;

import com.pieceofcake.memberservice.member.entity.Member;
import com.pieceofcake.memberservice.member.vo.in.ReadProfileImageRequestVo;
import com.pieceofcake.memberservice.member.vo.out.ReadProfileImageResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReadProfileImageResponseDto {
    private String profileImageUrl;
    private String nickname;

    @Builder
    public ReadProfileImageResponseDto(
            String profileImageUrl,
            String nickname
    ) {
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
    }

    public static ReadProfileImageResponseDto from(Member member) {
        return ReadProfileImageResponseDto.builder()
                .profileImageUrl(member.getProfileImageUrl())
                .nickname(member.getNickname())
                .build();
    }

    public ReadProfileImageResponseVo toVo() {
        return ReadProfileImageResponseVo.builder()
                .profileImageUrl(profileImageUrl)
                .nickname(nickname)
                .build();
    }
}
