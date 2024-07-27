package com.core.accountbook.auth.util;

import com.core.accountbook.auth.domain.TokenProperties;
import com.core.accountbook.auth.exception.AuthErrorCode;
import com.core.accountbook.auth.exception.AuthException;
import com.core.accountbook.common.exception.ErrorCode;
import com.core.accountbook.common.exception.globalerror.UnExpectedErrorCode;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.DecodingException;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.security.WeakKeyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class BearerTokenValidator {

    private final TokenProperties tokenProperties;

    public Long validateToken(String accessToken) {

        Claims claim = extractClaim(accessToken);
        return claim != null ? claim.get("id", Long.class) : null;
    }

    private Claims extractClaim(String accessToken) {

        try {
            return Jwts.parserBuilder()
                    .setSigningKey(SigningUtil.getSigningKey(tokenProperties.getSecretKey()))
                    .build()
                    .parseClaimsJws(accessToken)
                    .getBody();

        } catch (JwtException | IllegalArgumentException e) {
            handleJwtException(e);
            return null;
        }
    }

    private void handleJwtException(RuntimeException e) {
        Map<Class<? extends RuntimeException>, ErrorCode> exceptionMap = Map.of(
                DecodingException.class, AuthErrorCode.INVALID_SIGNATURE,
                WeakKeyException.class, AuthErrorCode.INVALID_SIGNATURE,
                SignatureException.class, AuthErrorCode.INVALID_SIGNATURE,
                NullPointerException.class, AuthErrorCode.INVALID_SIGNATURE,
                MalformedJwtException.class, AuthErrorCode.INVALID_TOKEN_FORMAT,
                ExpiredJwtException.class, AuthErrorCode.EXPIRED_TOKEN
        );

        ErrorCode authErrorCode = exceptionMap.getOrDefault(e.getClass(), UnExpectedErrorCode.INTERNAL_SERVER_ERROR);

        throw new AuthException(authErrorCode, e);
    }


}
