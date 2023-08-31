package co.cstad.song.s_advance_jpa_restful_hw1.api.transaction;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/transfer")
    public ResponseEntity<String> transferFunds(
            @RequestParam Long fromAccountId,
            @RequestParam Long toAccountId,
            @RequestParam BigDecimal amount) {

        System.out.println(fromAccountId);

        transactionService.performTransaction(fromAccountId, toAccountId, amount);

        return ResponseEntity.ok("*Sender from account id:"+fromAccountId
                +" *Receiver from account id:"+toAccountId+" *amount is:"+amount);
    }
}
