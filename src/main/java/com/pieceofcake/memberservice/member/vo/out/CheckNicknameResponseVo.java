package com.pieceofcake.memberservice.member.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CheckNicknameResponseVo {
    private boolean available;

    @Builder
    public CheckNicknameResponseVo(boolean available) {
        this.available = available;
    }
}
