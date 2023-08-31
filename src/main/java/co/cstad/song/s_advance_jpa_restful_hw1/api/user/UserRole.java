package co.cstad.song.s_advance_jpa_restful_hw1.api.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "users_roles")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private UserRole role;
    @CreationTimestamp
    private Timestamp create_at;
    @UpdateTimestamp
    private Timestamp update_at;
}
