package com.core.accountbook.transaction.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum TransactionType {
    SPENT("지출"),
    EARNED("수입"),
    TRANSFER("이체");

    private final String description;

    public static TransactionType valueOfTransactionType(String transactionType) {
        return Stream.of(TransactionType.values())
                .filter(type -> isEqualsTypeName(type.description, transactionType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(transactionType));
    }

    private static boolean isEqualsTypeName(String description, String transactionType) {
        return description.equals(transactionType);
    }
}
