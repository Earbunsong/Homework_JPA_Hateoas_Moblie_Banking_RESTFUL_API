package co.cstad.song.s_advance_jpa_restful_hw1.api.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User,Long> {

//    List<User> findByEmailAndIsDeletedFalse();

    Optional<User> findByUuid(String uuid);


    boolean existsByUuid(String uuid);

    void isDeleted(String uuid);

    @Modifying
    @Query("UPDATE User u SET u.isDeleted = :isDeleted WHERE u.uuid = :uuid")
    void updateIsDeletedByUuid(@Param("isDeleted") Boolean isDeleted, @Param("uuid") String uuid);

    void deleteUserByUuid(String uuid);
}
