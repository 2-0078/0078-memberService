package com.pieceofcake.memberservice.kafka.consumer.controller;

import com.pieceofcake.memberservice.kafka.consumer.event.SignUpEvent;
import com.pieceofcake.memberservice.member.application.MemberServiceImpl;
import com.pieceofcake.memberservice.member.dto.in.CreateMemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumerController {
    private final MemberServiceImpl memberServiceImpl;

    @KafkaListener(
            topics = "member-signup-data",
            groupId = "member-group",
            containerFactory = "signUpListenerFactory")
    public void consumeSignUpEvent(SignUpEvent signUpEvent) {
        memberServiceImpl.createMember(CreateMemberDto.from(signUpEvent));
    }

}
