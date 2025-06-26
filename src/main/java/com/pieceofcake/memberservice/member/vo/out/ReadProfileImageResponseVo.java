package com.pieceofcake.memberservice.member.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReadProfileImageResponseVo {
    private String profileImageUrl;
    private String nickname;

    @Builder
    public ReadProfileImageResponseVo(
            String profileImageUrl,
            String nickname
    ) {
        this.profileImageUrl = profileImageUrl;
        this.nickname = nickname;
    }
}
