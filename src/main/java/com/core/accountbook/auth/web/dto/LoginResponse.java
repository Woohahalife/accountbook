package com.core.accountbook.auth.web.dto;

import com.core.accountbook.member.domain.Member;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginResponse {

    private Long memberId;
    private String accessToken;

    public static LoginResponse of(Member member, String accessToken) {
        return new LoginResponse(member.getId(), accessToken);
    }
}
