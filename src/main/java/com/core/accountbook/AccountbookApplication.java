package com.core.accountbook;

import com.core.accountbook.auth.domain.TokenProperties;
import com.core.accountbook.common.properties.SmtpMailProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@EnableConfigurationProperties({TokenProperties.class, SmtpMailProperties.class})
public class AccountbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountbookApplication.class, args);
	}

}
