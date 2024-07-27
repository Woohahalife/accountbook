package com.core.accountbook.auth.exception;

import com.core.accountbook.common.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum AuthErrorCode implements ErrorCode {
    INVALID_TOKEN_FORMAT(false, HttpStatus.UNAUTHORIZED.value(), "올바른 토큰 형식이 아닙니다."),
    BAD_CREDENTIALS(false, HttpStatus.UNAUTHORIZED.value(), "사용자 정보가 잘못되었습니다."),
    EXPIRED_TOKEN(false, HttpStatus.UNAUTHORIZED.value(), "토큰 유효기간이 만료되었습니다."),
    INVALID_SIGNATURE(false, HttpStatus.UNAUTHORIZED.value(), "서명 정보가 잘못되었습니다.");

    private final boolean isSuccess;
    private final int statusCode;
    private final String message;
}
