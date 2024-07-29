package com.core.accountbook.common.properties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ConfigurationProperties(prefix = "spring.mail")
public class SmtpMailProperties {

    private String host;

    private int port;

    private String username;

    private String password;

    private String encode;

    @Value("${spring.mail.properties.mail.smtp.auth}")
    private boolean auth;

    @Value("${spring.mail.properties.mail.smtp.timeout}")
    private int timeout;

    @Value("${spring.mail.properties.mail.smtp.connection-timeout}")
    private int connectionTimeout;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private boolean starttlsEnable;

    @Value("${spring.mail.properties.mail.smtp.starttls.required}")
    private boolean starttlsRequired;

}
