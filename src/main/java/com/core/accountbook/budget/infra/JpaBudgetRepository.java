package com.core.accountbook.budget.infra;

import com.core.accountbook.budget.domain.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBudgetRepository extends JpaRepository<Budget, Long> {
}
