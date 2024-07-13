package com.core.accountbook.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "가계부 프로젝트 api 명세서",
                description = "<h3>도메인 주도 기반 가계부 구현 프로젝트</h3>",
                version = "v1"
        )
)
public class SwaggerConfig {

    String root = "com.core.accountbook";
    String[] paths = {
            root
    };

    @Bean
    public GroupedOpenApi getEntireApi() {
        return GroupedOpenApi.builder()
                .group("ENTIRE")
                .packagesToScan(paths)
                .build();
    }
}
