package co.cstad.song.s_advance_jpa_restful_hw1.api.user;

import co.cstad.song.s_advance_jpa_restful_hw1.api.user.web.CreateUserDto;
import co.cstad.song.s_advance_jpa_restful_hw1.api.user.web.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToUserDto(User user);

    CreateUserDto toUserDto(UserDto userDto);

    User createUserDtoToUser(CreateUserDto createUserDto);

    User toEntity(CreateUserDto createUserDto);

    List<UserDto> mapProductsToProductDtoList(List<User> user);
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
