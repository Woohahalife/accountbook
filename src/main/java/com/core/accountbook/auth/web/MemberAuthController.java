package com.core.accountbook.auth.web;

import com.core.accountbook.auth.appliction.MemberAuthService;
import com.core.accountbook.auth.web.dto.LoginRequest;
import com.core.accountbook.auth.web.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class MemberAuthController {

    private final MemberAuthService memberAuthService;

    @PostMapping("/login")
    public LoginResponse localLogin(@RequestBody LoginRequest request) {
        return memberAuthService.localLogin(request);
    }
}
