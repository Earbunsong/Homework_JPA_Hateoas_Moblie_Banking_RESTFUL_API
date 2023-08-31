package co.cstad.song.s_advance_jpa_restful_hw1.api.accountype;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "account_types")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
