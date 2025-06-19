package com.pieceofcake.memberservice.member.dto.in;

import com.pieceofcake.memberservice.kafka.consumer.event.SignUpEvent;
import com.pieceofcake.memberservice.member.entity.Member;
import com.pieceofcake.memberservice.member.entity.enums.MemberGender;
import com.pieceofcake.memberservice.member.entity.enums.MemberStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CreateMemberDto {

    private String memberUuid;
    private String email;
    private String name;
    private String phoneNumber;
    private LocalDateTime birthdate;
    private MemberGender gender;
    private String nickname;



    @Builder
    public CreateMemberDto(
            String memberUuid,
            String email,
            String name,
            String phoneNumber,
            LocalDateTime birthdate,
            MemberGender gender,
            String nickname
    ) {
        this.memberUuid = memberUuid;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
        this.gender = gender;
        this.nickname = nickname;
    }

    public static CreateMemberDto from(SignUpEvent signUpEvent) {
        return CreateMemberDto.builder()
                .memberUuid(signUpEvent.getMemberUuid())
                .email(signUpEvent.getEmail())
                .name(signUpEvent.getName())
                .phoneNumber(signUpEvent.getPhoneNumber())
                .gender(signUpEvent.getGender())
                .birthdate(signUpEvent.getBirthdate())
                .nickname(signUpEvent.getNickname())
                .build();
    }

    public Member toEntity() {
        return Member.builder()
                .memberUuid(memberUuid)
                .email(email)
                .name(name)
                .phoneNumber(phoneNumber)
                .birthdate(birthdate)
                .gender(gender)
                .status(MemberStatus.ENABLED) // 기본 상태는 ENABLED로 설정
                .nickname(nickname)
                .build();
    }
}
