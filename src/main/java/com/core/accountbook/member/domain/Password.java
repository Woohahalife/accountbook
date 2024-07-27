package com.core.accountbook.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Password {

    @Column(nullable = false)
    private String password;

    @Column(name = "password_expiration_date")
    private LocalDateTime expirationDate;

    protected Password(String password) {
        this.password = password;
        this.expirationDate = LocalDateTime.now().plusMonths(6L); // 만료 6개월 설정
    }

    public Password encodePassword(String password, PasswordEncryptor encoder) {
        this.password = encoder.encrypt(password);
        return this;
    }

    public String decode(PasswordEncryptor decoder) {

        return decoder.decrypt(this.password);
    }
}

