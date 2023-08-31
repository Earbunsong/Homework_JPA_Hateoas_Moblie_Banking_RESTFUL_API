package co.cstad.song.s_advance_jpa_restful_hw1.api.transaction;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    @Transactional
    @Override
    public void performTransaction(Long fromAccountId, Long toAccountId, BigDecimal amount) {
        transactionRepository.transferFunds(fromAccountId, toAccountId, amount);
    }
}
