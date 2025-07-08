package com.pieceofcake.memberservice.member.vo.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CheckPhoneNumberResponseVo {
    private boolean available;

    @Builder
    public CheckPhoneNumberResponseVo(boolean available) {
        this.available = available;
    }
}
