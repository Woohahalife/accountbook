package com.core.accountbook.member.application.dto;

import com.core.accountbook.member.domain.LoginType;
import com.core.accountbook.member.domain.Member;
import com.core.accountbook.member.domain.Password;
import com.core.accountbook.member.domain.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class SignUpServiceRequest {

    private String email;
    private String password;
    private String name;
    private String address;
    private String phoneNumber;

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .address(address)
                .phoneNumber(phoneNumber)
                .role(Role.USER)
                .loginType(LoginType.LOCAL)
                .emailVerified(false) // TODO : email 인증 구현시 그에 맞춰 처리
                .lockCount(0)
                .build();
    }
}

