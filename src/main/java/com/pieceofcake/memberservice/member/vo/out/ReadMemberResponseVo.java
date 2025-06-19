package com.pieceofcake.memberservice.member.vo.out;

import com.pieceofcake.memberservice.member.entity.enums.MemberGender;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ReadMemberResponseVo {

    private String email;
    private String name;
    private LocalDateTime birthdate;
    private MemberGender gender;
    private String nickname;
    private String profileImageUrl;

    @Builder
    public ReadMemberResponseVo(
            String email,
            String name,
            LocalDateTime birthdate,
            MemberGender gender,
            String nickname,
            String profileImageUrl
    ) {
        this.email = email;
        this.name = name;
        this.birthdate = birthdate;
        this.gender = gender;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
    }
}
