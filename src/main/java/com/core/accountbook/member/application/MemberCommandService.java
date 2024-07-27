package com.core.accountbook.member.application;

import com.core.accountbook.member.application.dto.SignUpServiceRequest;
import com.core.accountbook.member.domain.Member;
import com.core.accountbook.member.domain.PasswordEncryptor;
import com.core.accountbook.member.domain.repository.MemberRepository;
import com.core.accountbook.member.exception.MemberErrorCode;
import com.core.accountbook.member.exception.MemberException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberCommandService {

    private final MemberRepository memberRepository;
    private final PasswordEncryptor passwordEncoder;

    public void signUp(SignUpServiceRequest request) {

        validateDuplicateEmail(request.getEmail());
        validateDuplicatePhoneNumber(request.getPhoneNumber());

        // TODO : emailVerify System 구축

        Member member = request.toEntity()
                .encode(request.getPassword(), passwordEncoder);

        memberRepository.save(member);
    }

    private void validateDuplicateEmail(String email) {
        if(memberRepository.existsByEmail(email)) {
            throw new MemberException(MemberErrorCode.DUPLICATE_EMAIL);
        }
    }

    private void validateDuplicatePhoneNumber(String phoneNumber) {
        if(memberRepository.existsByEmail(phoneNumber)) {
            throw new MemberException(MemberErrorCode.DUPLICATE_PHONE_NUMBER);
        }
    }
}
