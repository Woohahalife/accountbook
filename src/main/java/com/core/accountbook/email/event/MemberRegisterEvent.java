package com.core.accountbook.email.event;

import com.core.accountbook.common.event.DomainEvent;
import com.core.accountbook.member.domain.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberRegisterEvent extends DomainEvent {
    private final Member member;
}
