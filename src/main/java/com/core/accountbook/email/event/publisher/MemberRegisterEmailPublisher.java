package com.core.accountbook.email.event.publisher;

import com.core.accountbook.email.event.MemberRegisterEvent;
import com.core.accountbook.member.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * 회원가입 축하 email 발송 이벤트 발행 책임을 가지는 클래스
 */
@Slf4j
@Component
public class MemberRegisterEmailPublisher implements ApplicationEventPublisherAware {

    private static ApplicationEventPublisher applicationEventPublisher;


    public static void publishEvent(final Member member) {
        log.info("이벤트 발행 시작 - MemberRegisterEmailPublisher");
        MemberRegisterEvent event = new MemberRegisterEvent(member);

        applicationEventPublisher.publishEvent(event);
        log.info("이벤트 발행 종료 - MemberRegisterEmailPublisher");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        MemberRegisterEmailPublisher.applicationEventPublisher = applicationEventPublisher;
    }
}
