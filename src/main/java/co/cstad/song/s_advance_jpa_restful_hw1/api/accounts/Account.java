package co.cstad.song.s_advance_jpa_restful_hw1.api.accounts;

import co.cstad.song.s_advance_jpa_restful_hw1.api.accountype.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "accounts")
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String pin;
    private String transferLimit;
    private String actName;
    private String actNo;

    private BigDecimal balance;
    @ManyToOne
    private AccountType accountType;
    @OneToMany(mappedBy = "account")
    private List<UserAccount> userAccounts;
}
