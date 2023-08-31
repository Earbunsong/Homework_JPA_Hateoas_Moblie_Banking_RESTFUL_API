package co.cstad.song.s_advance_jpa_restful_hw1.api.accounts;

import co.cstad.song.s_advance_jpa_restful_hw1.api.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "user_account")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {
   @Id
   @GeneratedValue
   private Long id;
   private Boolean is_disabled;
   @CreationTimestamp
   private Timestamp create_at;
   @UpdateTimestamp
   private Timestamp update_at;
   @ManyToOne(fetch = FetchType.LAZY)
   private User user;
   @ManyToOne(fetch =  FetchType.LAZY)
   private Account account;
}
