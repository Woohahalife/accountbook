package com.core.accountbook.config;

import com.core.accountbook.common.properties.SmtpMailProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * mailSender 사용을 위한 기본 프로퍼티 구성 클래스
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class MailConfig {

    private final SmtpMailProperties smtpMailProperties;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(smtpMailProperties.getHost());
        mailSender.setPort(smtpMailProperties.getPort());
        mailSender.setUsername(smtpMailProperties.getUsername());
        mailSender.setPassword(smtpMailProperties.getPassword());
        mailSender.setDefaultEncoding(smtpMailProperties.getEncode());
        mailSender.setJavaMailProperties(getProperties());
        mailSender.getJavaMailProperties();

        return mailSender;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", smtpMailProperties.isAuth());
        properties.put("mail.smtp.starttls.enable", smtpMailProperties.isStarttlsEnable());
        properties.put("mail.smtp.starttls.required", smtpMailProperties.isStarttlsRequired());
        properties.put("mail.smtp.connection-timeout", smtpMailProperties.getConnectionTimeout());
        properties.put("mail.smtp.timeout", smtpMailProperties.getTimeout());

        return properties;
    }
}
