package com.core.accountbook.auth.exception;

import com.core.accountbook.common.exception.DefaultException;
import com.core.accountbook.common.exception.ErrorCode;

public class AuthException extends DefaultException {

    public AuthException(ErrorCode errorCode) {
        super(errorCode);
    }

    public AuthException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public AuthException(ErrorCode errorCode, String customMessage) {
        super(errorCode, customMessage);
    }

    public AuthException(ErrorCode errorCode, String customMessage, Throwable cause) {
        super(errorCode, customMessage, cause);
    }
}
