package com.core.accountbook.member.infra.database;

import com.core.accountbook.member.domain.LoginType;
import com.core.accountbook.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaMemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmailAndLoginType(final String email, final LoginType loginType);

    boolean existsByEmail(final String email);

    boolean existsByPhoneNumber(final String phoneNumber);
}
