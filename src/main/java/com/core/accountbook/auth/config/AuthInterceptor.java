package com.core.accountbook.auth.config;

import com.core.accountbook.auth.util.BearerTokenParser;
import com.core.accountbook.auth.util.BearerTokenValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final BearerTokenParser bearerTokenParser;
    private final BearerTokenValidator bearerTokenValidator;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        String accessToken = bearerTokenParser.parse(header);
        Long memberId = bearerTokenValidator.validateToken(accessToken);
        request.setAttribute("memberId", memberId);

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
