package com.pieceofcake.memberservice.member.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CheckEmailResponseVo {
    public boolean available;

    @Builder
    public CheckEmailResponseVo(boolean available) {
        this.available = available;
    }
}
