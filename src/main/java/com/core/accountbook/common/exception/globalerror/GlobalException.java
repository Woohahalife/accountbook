package com.core.accountbook.common.exception.globalerror;

import com.core.accountbook.common.exception.DefaultException;
import com.core.accountbook.common.exception.ErrorCode;

public class GlobalException extends DefaultException {

    public GlobalException(ErrorCode errorCode) {
        super(errorCode);
    }

    public GlobalException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public GlobalException(ErrorCode errorCode, String customMessage) {
        super(errorCode, customMessage);
    }

    public GlobalException(ErrorCode errorCode, String customMessage, Throwable cause) {
        super(errorCode, customMessage, cause);
    }
}
