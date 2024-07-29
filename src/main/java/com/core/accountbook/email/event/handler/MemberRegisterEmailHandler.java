package com.core.accountbook.email.event.handler;

import com.core.accountbook.email.event.MemberRegisterEvent;
import com.core.accountbook.email.service.EmailService;
import com.core.accountbook.member.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * 발행된 이벤트를 구독해 내부 로직을 처리하는 책임을 가진 클래스
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MemberRegisterEmailHandler {

    private final EmailService emailService;

    @Async
    @TransactionalEventListener(
            classes = MemberRegisterEvent.class,
            phase = TransactionPhase.AFTER_COMMIT
    )
    public void handleEvent(MemberRegisterEvent memberRegisterEvent) {
        log.info("이벤트 핸들링 시작 - {}", this.getClass().getSimpleName());

        Member member = memberRegisterEvent.getMember();
        emailService.sendEmail(member.getEmail(), member.getName());

        log.info("이벤트 핸들링 종료 - {}", this.getClass().getSimpleName());
    }
}
