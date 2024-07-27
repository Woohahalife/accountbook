package com.core.accountbook.member.infra.database;

import com.core.accountbook.member.domain.LoginType;
import com.core.accountbook.member.domain.Member;
import com.core.accountbook.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final JpaMemberRepository jpaMemberRepository;

    @Override
    public Member save(Member member) {
        return jpaMemberRepository.save(member);
    }

    @Override
    public Optional<Member> findByEmailAndLoginType(final String email, final LoginType loginType) {
        return jpaMemberRepository.findByEmailAndLoginType(email, loginType);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaMemberRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByPhoneNumber(String phoneNumber) {
        return jpaMemberRepository.existsByPhoneNumber(phoneNumber);
    }
}
