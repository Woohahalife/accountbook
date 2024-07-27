package com.core.accountbook.common.exception.globalerror;

import com.core.accountbook.common.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GlobalErrorCode implements ErrorCode {
    ALREADY_DELETED_DATA(false, 400, "이미 삭제처리 된 데이터입니다.");

    private final boolean isSuccess;
    private final int statusCode;
    private final String message;

}
