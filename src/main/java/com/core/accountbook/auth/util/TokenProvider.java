package com.core.accountbook.auth.util;

import com.core.accountbook.auth.domain.TokenProperties;
import com.core.accountbook.member.domain.LoginType;
import com.core.accountbook.member.domain.Member;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Jwt를 생성하는 클래스
 */
@Component
@RequiredArgsConstructor
public class TokenProvider {

    public String generateAccessToken(TokenProperties tokenProperties, Member member, LoginType loginType) {
        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiration = new Date(System.currentTimeMillis() + tokenProperties.getExpireLength());

        return Jwts.builder()
                .setSubject(loginType.name())
                .claim("id", member.getId())
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .signWith(SigningUtil.getSigningKey(tokenProperties.getSecretKey()), SignatureAlgorithm.HS256)
                .compact();
    }
}
