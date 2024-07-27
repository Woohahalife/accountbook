package com.core.accountbook.auth.web.dto;

import lombok.Getter;

@Getter
public class AuthMember {

    private final Long memberId;

    public AuthMember(Long memberId) {
        this.memberId = memberId;
    }
}
