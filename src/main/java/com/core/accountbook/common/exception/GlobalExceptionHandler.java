package com.core.accountbook.common.exception;

import com.core.accountbook.common.response.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 직접 작성한 CustomException을 처리하는 Handler
     * DefaultException을 상속받은 하위 예외는 전부 해당 메서드에서 처리됨
     */
    @ExceptionHandler(DefaultException.class)
    public ResponseEntity<Object> testExceptionHandler(DefaultException e) {
        log.error("[Exception] message: {} kind: {}", e.getMessage(), e.getClass().getSimpleName());

        return e.getMessage() == null ? ResponseEntity.status(e.getErrorCode().getStatusCode()).body(e.getErrorCode()) :
                ResponseEntity.status(e.getErrorCode().getStatusCode()).body(ResultResponse.failure(e.getErrorCode(), e.getMessage()));
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ResponseEntity<Object> handleException(Exception e) {

        log.error("[Exception] message: {} kind: {}", e.getMessage(), e.getClass().getSimpleName());
        return ResponseEntity.status(UnExpectedErrorCode.INTERNAL_SERVER_ERROR.getStatusCode())
                .body(UnExpectedErrorCode.INTERNAL_SERVER_ERROR);
    }

}
