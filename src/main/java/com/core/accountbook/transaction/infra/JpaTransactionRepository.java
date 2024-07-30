package com.core.accountbook.transaction.infra;

import com.core.accountbook.transaction.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTransactionRepository extends JpaRepository<Transaction, Long> {
}
