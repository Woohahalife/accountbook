package com.core.accountbook.common.exception.globalerror;

import com.core.accountbook.common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum GlobalErrorCode implements ErrorCode {
    ALREADY_DELETED_DATA(false, 400, "이미 삭제처리 된 데이터입니다.");

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
