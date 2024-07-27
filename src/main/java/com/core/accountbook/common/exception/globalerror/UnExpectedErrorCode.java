package com.core.accountbook.common.exception.globalerror;

import com.core.accountbook.common.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UnExpectedErrorCode implements ErrorCode {

    INTERNAL_SERVER_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "미확인 서버 에러");

    private final boolean isSuccess;
    private final int statusCode;
    private final String message;

}
