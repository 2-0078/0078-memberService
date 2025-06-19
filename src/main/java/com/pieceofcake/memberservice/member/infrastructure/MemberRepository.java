package com.pieceofcake.memberservice.member.infrastructure;


import com.pieceofcake.memberservice.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByNickname(String nickname);

    Optional<Member> findByMemberUuid(String memberUuid);

    Optional<Member> findByEmail(String email);

    Optional<Member> findByPhoneNumberAndName(String phoneNumber, String name);
}
