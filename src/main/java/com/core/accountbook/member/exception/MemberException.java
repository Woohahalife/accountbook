package com.core.accountbook.member.exception;

import com.core.accountbook.common.exception.DefaultException;
import com.core.accountbook.common.exception.ErrorCode;

public class MemberException extends DefaultException {

    public MemberException(ErrorCode errorCode) {
        super(errorCode);
    }

    public MemberException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public MemberException(ErrorCode errorCode, String customMessage) {
        super(errorCode, customMessage);
    }

    public MemberException(ErrorCode errorCode, String customMessage, Throwable cause) {
        super(errorCode, customMessage, cause);
    }
}
