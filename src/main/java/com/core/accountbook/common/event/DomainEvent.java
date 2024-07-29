package com.core.accountbook.common.event;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 이벤트 기본 정보(발생 시점)를 담고 있는 공통 클래스
 * 구체적인 도메인별 이벤트는 해당 클래스를 상속해 발생 시점 정보를 가지게 됨
 */
@Getter
public class DomainEvent {
    private final LocalDateTime publishAt;

    public DomainEvent() {
        this.publishAt = LocalDateTime.now();
    }
}
