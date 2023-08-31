package co.cstad.song.s_advance_jpa_restful_hw1.api.user;

import co.cstad.song.s_advance_jpa_restful_hw1.api.accounts.Account;
import co.cstad.song.s_advance_jpa_restful_hw1.api.user.web.CreateUserDto;
import co.cstad.song.s_advance_jpa_restful_hw1.api.user.web.UpdateUserDto;
import co.cstad.song.s_advance_jpa_restful_hw1.api.user.web.UserDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.List;

public interface UserService {

    User createNew(CreateUserDto createUserDto);
    EntityModel<?> findByUuid(String uuid);
    void deleteByUuid(String uuid);
    void deletedUserByUuid(String uuid);
    void disableByUuid(String uuid);
//    EntityModel<?> findUserByUUID(String uuid);
    User updateByUuid(String uuid, UpdateUserDto updateUserDto);
    void renameByUuid(String uuid, String pin);
    User disableUser(String uuid);
    CollectionModel<?> findAllUser();
    List<Account> getUserAccountsByUuid(String uuid);
    Account getAccountByUserUuidAndAccountUuid(String userUuid,String AccountUuid);
}
