package com.pieceofcake.memberservice.member.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pieceofcake.memberservice.member.entity.enums.MemberGender;
import com.pieceofcake.memberservice.member.entity.enums.MemberStatus;
import com.pieceofcake.memberservice.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "member_uuid", nullable = false, unique = true, updatable = false)
    private String memberUuid;

    @Column(name = "email", nullable = false, unique = true, updatable = false)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "birth_date", nullable = false)
    private LocalDateTime birthdate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private MemberGender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private MemberStatus status;

    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @Builder
    public Member(
            Long id,
            String memberUuid,
            String email,
            String name,
            String phoneNumber,
            LocalDateTime birthdate,
            MemberGender gender,
            MemberStatus status,
            String nickname,
            String profileImageUrl
    ) {
        this.id = id;
        this.memberUuid = memberUuid;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
        this.gender = gender;
        this.status = status;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
    }

}
