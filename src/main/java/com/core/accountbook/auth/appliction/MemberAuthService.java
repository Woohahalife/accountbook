package com.core.accountbook.auth.appliction;

import com.core.accountbook.auth.domain.TokenProperties;
import com.core.accountbook.auth.exception.AuthErrorCode;
import com.core.accountbook.auth.exception.AuthException;
import com.core.accountbook.auth.util.TokenProvider;
import com.core.accountbook.auth.web.dto.LoginRequest;
import com.core.accountbook.auth.web.dto.LoginResponse;
import com.core.accountbook.member.domain.LoginType;
import com.core.accountbook.member.domain.Member;
import com.core.accountbook.member.domain.PasswordEncryptor;
import com.core.accountbook.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberAuthService {

    private final TokenProperties tokenProperties;
    private final TokenProvider tokenProvider;
    private final MemberRepository memberRepository;
    private final PasswordEncryptor passwordEncryptor;

    public LoginResponse localLogin(LoginRequest request) {

        Member member = verifyEmailAndLoginType(request);
        verifyPassword(request, member, passwordEncryptor);

        String accessToken = tokenProvider.generateAccessToken(tokenProperties, member, LoginType.LOCAL);

        return LoginResponse.of(member, accessToken);
    }

    private void verifyPassword(LoginRequest request, Member member, PasswordEncryptor passwordEncryptor) {
        if(!member.checkPassword(request.getPassword(), passwordEncryptor)) {
            throw new AuthException(AuthErrorCode.BAD_CREDENTIALS);
        }
    }

    private Member verifyEmailAndLoginType(LoginRequest request) {
        return memberRepository.findByEmailAndLoginType(request.getEmail(), LoginType.LOCAL)
                .orElseThrow(() -> new AuthException(AuthErrorCode.BAD_CREDENTIALS));
    }
}
