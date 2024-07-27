package com.core.accountbook.config;

import com.core.accountbook.auth.config.AuthArgumentResolver;
import com.core.accountbook.auth.config.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final String ROOT_PATH = "/api/v1";

    private final AuthInterceptor authInterceptor;
    private final AuthArgumentResolver authArgumentResolver;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer
                .addPathPrefix(ROOT_PATH,
                        HandlerTypePredicate.forBasePackage("com.core.accountbook")
                                .and(HandlerTypePredicate.forAnnotation(RestController.class)))
                .setPathMatcher(new AntPathMatcher());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns(ROOT_PATH + "/**")
                .excludePathPatterns(ROOT_PATH + "/auth/**")
                .excludePathPatterns(ROOT_PATH + "/member/signup");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(authArgumentResolver);
    }
}
