package com.pieceofcake.memberservice.member.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CheckPhoneNumberRequestDto {
    private String phoneNumber;

    @Builder
    public CheckPhoneNumberRequestDto(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static CheckPhoneNumberRequestDto of(String phoneNumber) {
        return CheckPhoneNumberRequestDto.builder()
                .phoneNumber(phoneNumber)
                .build();
    }
}
