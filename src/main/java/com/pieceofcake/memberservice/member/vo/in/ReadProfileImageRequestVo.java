package com.pieceofcake.memberservice.member.vo.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReadProfileImageRequestVo {

    private String memberUuid;

    @Builder
    public ReadProfileImageRequestVo(String memberUuid) {
        this.memberUuid = memberUuid;
    }
}
