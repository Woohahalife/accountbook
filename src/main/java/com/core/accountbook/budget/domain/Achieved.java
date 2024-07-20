package com.core.accountbook.budget.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum Achieved {

    ACHIEVED("달성"),
    NOT_ACHIEVED("미달성"),
    IN_PROGRESS("진행 중"),
    NOT_STARTED("진행 전");

    private final String description;

    private static Achieved valueOfAchieved(String achieved) {
        return Stream.of(Achieved.values())
                .filter(achieve -> isEqualsTypeName(achieve.description, achieved))
                .findFirst()
                .orElseThrow();
    }

    private static boolean isEqualsTypeName(String description, String transactionType) {
        return description.equals(transactionType);
    }
}
