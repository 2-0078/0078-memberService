package com.pieceofcake.memberservice.member.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CheckNicknameRequestDto {

    private String nickname;

    @Builder
    public CheckNicknameRequestDto(String nickname) {
        this.nickname = nickname;
    }

    public static CheckNicknameRequestDto of(String nickname) {
        return CheckNicknameRequestDto.builder()
                .nickname(nickname)
                .build();
    }
}
