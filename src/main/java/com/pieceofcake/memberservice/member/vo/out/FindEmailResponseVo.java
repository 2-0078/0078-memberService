package com.pieceofcake.memberservice.member.vo.out;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FindEmailResponseVo {
    private String email;

    @Builder
    public FindEmailResponseVo(String email) {
        this.email = email;
    }
}
