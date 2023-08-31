package co.cstad.song.s_advance_jpa_restful_hw1.api.user;

import co.cstad.song.s_advance_jpa_restful_hw1.api.accounts.UserAccount;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    @Column(unique = true, nullable = false, length = 50)
    private String name;
    private String gender;

    private String email;
    @Column(name = "is_student")
    private Boolean isStudent;
    @Column(name = "is_verified")
    private Boolean isVerified;
    private String oneSignalId;
    private String password;
    private Integer phoneNumber;
    private Boolean studentCardNo;
    private String verifiedCode;
    private String isDeleted;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<UserRole> userRoles;
    @OneToMany(mappedBy = "user")
    private List<UserAccount> userAccounts;

}
