package com.pieceofcake.memberservice.member.dto.out;

import com.pieceofcake.memberservice.member.vo.out.CheckPhoneNumberResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckPhoneNumberResponseDto {
    private boolean available;

    public CheckPhoneNumberResponseVo toVo() {
        return CheckPhoneNumberResponseVo.builder()
                .available(available)
                .build();
    }
}
