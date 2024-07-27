package com.core.accountbook.member.web;

import com.core.accountbook.member.application.MemberCommandService;
import com.core.accountbook.member.application.MemberQueryService;
import com.core.accountbook.member.web.dto.SignUpRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/signup")
    public void signUp(@Valid @RequestBody SignUpRequest request) {

        memberCommandService.signUp(request.toService());
    }


}
