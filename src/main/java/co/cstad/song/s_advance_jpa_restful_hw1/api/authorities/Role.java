package co.cstad.song.s_advance_jpa_restful_hw1.api.authorities;

import co.cstad.song.s_advance_jpa_restful_hw1.api.user.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "roles")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    @OneToMany(mappedBy = "role")
//    @JsonBackReference
//    private List<UserRole> userRoles;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    private List<Authority> authorities;


}
