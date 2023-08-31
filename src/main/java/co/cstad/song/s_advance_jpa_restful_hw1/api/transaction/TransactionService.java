package co.cstad.song.s_advance_jpa_restful_hw1.api.transaction;

import java.math.BigDecimal;

public interface TransactionService {
    void performTransaction(Long fromAccountId, Long toAccountId, BigDecimal amount);
}
