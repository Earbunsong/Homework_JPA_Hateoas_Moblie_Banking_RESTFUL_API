package co.cstad.song.s_advance_jpa_restful_hw1.api.transaction;

import co.cstad.song.s_advance_jpa_restful_hw1.api.accounts.Account;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "transactions")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Null
    private String uuid;
    private BigDecimal amount;
    private Boolean isPayment;
    private Timestamp transactionAt;
    private String remark;
    private String studentCardNo;
    @ManyToOne
    private Account senderActId;
    @ManyToOne
    private Account receiverActId;
}
