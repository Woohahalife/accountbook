package com.core.accountbook.common.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum UnExpectedErrorCode implements ErrorCode {
    INTERNAL_SERVER_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "미확인 서버 에러");

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
