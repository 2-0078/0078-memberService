package com.pieceofcake.memberservice.member.vo.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UploadProfileImageRequestVo {

    private String profileImageUrl;

    @Builder
    public UploadProfileImageRequestVo(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
