package com.core.accountbook.member.exception;

import com.core.accountbook.common.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MemberErrorCode implements ErrorCode {
    DUPLICATE_EMAIL(false, HttpStatus.BAD_REQUEST.value(), "중복되는 이메일입니다."),
    DUPLICATE_PHONE_NUMBER(false, HttpStatus.BAD_REQUEST.value(), "중복되는 휴대폰 번호입니다.");

    private final boolean isSuccess;
    private final int statusCode;
    private final String message;
}
