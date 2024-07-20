package com.core.accountbook.budget.domain;

import com.core.accountbook.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Budget extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private BigDecimal amount; // 예산으로 지정할 긂액

    @Column
    @Enumerated(EnumType.STRING)
    private Achieved achieved;

    @Column(name = "start_date", updatable = false)
    private LocalDate startDate;

    @Column(name = "due_date", updatable = false)
    private LocalDate dueDate;
}
