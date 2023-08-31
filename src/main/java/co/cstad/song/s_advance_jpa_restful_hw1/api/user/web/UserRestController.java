package co.cstad.song.s_advance_jpa_restful_hw1.api.user.web;

import co.cstad.song.s_advance_jpa_restful_hw1.api.user.User;
import co.cstad.song.s_advance_jpa_restful_hw1.api.user.UserService;
import co.cstad.song.s_advance_jpa_restful_hw1.base.BaseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {
     private final UserService userService;

     @PostMapping("/createNewUser")
     public BaseApi<?> createNewUser(@RequestBody CreateUserDto createUserDto){
        User user = userService.createNew(createUserDto);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(user)
                .message("You has been successfully....!!")
                .timestamp(LocalDateTime.now())
                .build();
     }
    @GetMapping("/{uuid}")
    public EntityModel<?> findUsersByUuid(@PathVariable String uuid) {
        return userService.findByUuid(uuid);
    }

    @PutMapping("/update/{uuid}")
    public BaseApi<?> updateUser(@RequestBody UpdateUserDto createUserDto,@PathVariable("uuid") String uuid) {

        User user = userService.updateByUuid(uuid,createUserDto);

        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data(user)
                .message("User has been updated!!!")
                .status(true)
                .timestamp(LocalDateTime.now())
                .build();
    }

    @DeleteMapping("/delete/{uuid}")
    public BaseApi<?> deleteUser(@PathVariable("uuid") String uuid) {
        userService.deleteByUuid(uuid);


        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data("your uuid delete : "+uuid)
                .message("User has been deleted!!")
                .status(true)
                .timestamp(LocalDateTime.now())
                .build();
    }
    @GetMapping
    public CollectionModel<?> findUsers() {
        return userService.findAllUser();
    }
    @PutMapping("/{uuid}/disable")
    public ResponseEntity<User> disableUserByUuid(@PathVariable String uuid) {
        User user = userService.disableUser(uuid);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/{uuid}")
    public BaseApi<Object> deleteUserByUuid(@PathVariable String uuid){
        userService.deletedUserByUuid(uuid);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .data("your uuid delete : "+uuid)
                .message("User has been UserDeleted!! by uuid")
                .status(true)
                .timestamp(LocalDateTime.now())
                .build();
    }

}
