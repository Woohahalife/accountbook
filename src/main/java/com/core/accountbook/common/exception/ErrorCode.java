package com.core.accountbook.common.exception;

import org.springframework.http.HttpStatus;

/**
 * 예외 코드와 메시지를 공통으로 관리하기 위한 인터페이스
 */
public interface ErrorCode {

    String name();
    boolean isSuccess();
    int getStatusCode();
    String getMessage();
}
