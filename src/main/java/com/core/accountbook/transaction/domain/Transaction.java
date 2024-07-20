package com.core.accountbook.transaction.domain;

import com.core.accountbook.categorydetail.domain.CategoryDetail;
import com.core.accountbook.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Transaction extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TransactionType transactionType;

    private CategoryDetail categoryDetail;

    private BigDecimal amount;

    private LocalDateTime transaction_date;

    private String content;

}
