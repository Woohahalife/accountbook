package com.core.accountbook.auth.domain;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "access-token")
public class TokenProperties {

    private final String secretKey;

    private final long expireLength;

    public TokenProperties(String secretKey, long expireLength) {
        this.secretKey = secretKey;
        this.expireLength = expireLength;
    }
}
