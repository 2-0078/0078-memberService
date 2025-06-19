package com.pieceofcake.memberservice.kafka.consumer.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pieceofcake.memberservice.member.entity.enums.MemberGender;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@NoArgsConstructor
public class SignUpEvent {
    private String memberUuid;
    private String email;
    private String name;
    private String phoneNumber;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime birthdate;

    private MemberGender gender;
    private String nickname;
}