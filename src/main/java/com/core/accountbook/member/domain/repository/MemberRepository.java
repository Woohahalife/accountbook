package com.core.accountbook.member.domain.repository;

import com.core.accountbook.member.domain.LoginType;
import com.core.accountbook.member.domain.Member;

import java.util.Optional;

public interface MemberRepository {

    Member save(final Member member);

    Optional<Member> findByEmailAndLoginType(final String email, final LoginType loginType);

    boolean existsByEmail(final String email);

    boolean existsByPhoneNumber(final String phoneNumber);
}