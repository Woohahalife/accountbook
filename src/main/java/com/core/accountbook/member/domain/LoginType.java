package com.core.accountbook.member.domain;

public enum LoginType {

    LOCAL,
    GOOGLE,
    NAVER,
    KAKAO;

    private static LoginType of(String name) {
        return LoginType.valueOf(name);
    }
}
