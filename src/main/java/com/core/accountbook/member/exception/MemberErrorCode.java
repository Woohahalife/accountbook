package com.core.accountbook.member.exception;

import com.core.accountbook.common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum MemberErrorCode implements ErrorCode {
    TEST_ERROR(false, HttpStatus.BAD_REQUEST.value(), "테스트용 에러입니다.");

    private final boolean isSuccess;
    private final int statusCode;
    private final String message;

    @Override
    public Boolean getIsSuccess() {
        return isSuccess;
    }

    @Override
    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
