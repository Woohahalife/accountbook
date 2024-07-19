package com.core.accountbook.common.response;

import com.core.accountbook.common.exception.ErrorCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 클라이언트에게 전달되는 응답을 커스터마이징 하기 위한 Advice class
 * Allows customizing the response after the execution of an @ResponseBody or a ResponseEntity controller method
 */
@RestControllerAdvice(basePackages = "com.core.accountbook")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ResultResponseAdvice implements ResponseBodyAdvice<Object> {

    private final ObjectMapper objectMapper;

    /**
     * 특정 응답에 대해 공통 처리를 할지 말지 결정하는 메서드
     * 반환 타입과 메시지 컨버터 타입을 매개변수로 받아, 사용자가 원하는대로 사용할 수 있다.
     * @param returnType 반환 타입
     * @param converterType 반환에 선택된 converter type
     * @return {@code true} if {@link #beforeBodyWrite} should be invoked;
     * 	 * {@code false} otherwise
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return converterType.isAssignableFrom(MappingJackson2HttpMessageConverter.class) ||
               converterType.isAssignableFrom(StringHttpMessageConverter.class);
    }

    /**
     * HttpMessageConverter가 선택된 후 쓰기 메서드가 호출되기 직전에 호출된다.
     * @param body 작성할 본문
     * @param returnType the return type of the controller method
     * @param selectedContentType the content type selected through content negotiation
     * @param selectedConverterType the converter type selected to write to the response
     * @param request the current request
     * @param response the current response
     * @return 전달된 body 혹은 수정된 instance
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {

        // 이미 응답이 Wrapping 되어 있는 경우
        if (body instanceof ResultResponse<?>) {
            return body;
        }

        // 예외 상황인 경우
        if (body instanceof ErrorCode errorCode) {
            return wrapResultResponse(ResultResponse.failure(errorCode), selectedConverterType);
        }

        return wrapResultResponse(ResultResponse.success(body), selectedConverterType);
    }

    private Object wrapResultResponse(ResultResponse<?> resultResponse, Class<? extends HttpMessageConverter<?>> converterType) {
        if (StringHttpMessageConverter.class.isAssignableFrom(converterType)) {
            try {
                return objectMapper.writeValueAsString(resultResponse);
            } catch (Exception e) {
                throw new RuntimeException("컨버팅 실패 에러 (ResultResponseAdvice)", e);
            }
        }
        return resultResponse;
    }
}
