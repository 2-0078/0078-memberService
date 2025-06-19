package com.pieceofcake.memberservice.member.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReadProfileImageResponseVo {
    private String profileImageUrl;

    @Builder
    public ReadProfileImageResponseVo(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
