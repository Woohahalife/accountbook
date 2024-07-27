package com.core.accountbook.member.application;

import com.core.accountbook.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberQueryService {

    private MemberRepository memberRepository;


}
