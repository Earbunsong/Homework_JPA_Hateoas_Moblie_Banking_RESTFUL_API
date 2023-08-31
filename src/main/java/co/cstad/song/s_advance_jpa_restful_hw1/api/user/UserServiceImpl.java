package co.cstad.song.s_advance_jpa_restful_hw1.api.user;
import co.cstad.song.s_advance_jpa_restful_hw1.api.accounts.Account;
import co.cstad.song.s_advance_jpa_restful_hw1.api.user.web.CreateUserDto;
import co.cstad.song.s_advance_jpa_restful_hw1.api.user.web.UpdateUserDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserModelAssembler userModelAssembler;


    @Override
    public User createNew(CreateUserDto createUserDto) {
        User user = userMapper.INSTANCE.toEntity(createUserDto);
        user.setUuid(UUID.randomUUID().toString());

        return userRepository.save(user);
    }


    @Override
    public EntityModel<?> findByUuid(String uuid) {
        User user = userRepository.findByUuid(uuid).orElseThrow();
        return userModelAssembler.toModel(user);
    }

    @Override
    public void deleteByUuid(String uuid) {
        User user = userRepository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("User not found"));

        userRepository.delete(user);
    }

    @Override
    public void deletedUserByUuid(String uuid) {
        userRepository.deleteUserByUuid(uuid);
    }


    @Override
    public void disableByUuid(String uuid) {
        userRepository.updateIsDeletedByUuid(true, uuid);
    }


    @Override
    public User updateByUuid(String uuid, UpdateUserDto updateUserDto) {
        User user = userRepository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("User not found"));
        BeanUtils.copyProperties(updateUserDto, user, uuid);
        return userRepository.save(user);
    }

    @Override
    public void renameByUuid(String uuid, String pin) {

    }

    @Override
    public User disableUser(String uuid) {
        return null;
    }

    @Override
    public CollectionModel<?> findAllUser() {
        List<User> users = userRepository.findAll();
        return userModelAssembler.toCollectionModel(users);
    }

    @Override
    public List<Account> getUserAccountsByUuid(String uuid) {

        return null;
    }

    @Override
    public Account getAccountByUserUuidAndAccountUuid(String userUuid, String AccountUuid) {

        return null;
    }
}