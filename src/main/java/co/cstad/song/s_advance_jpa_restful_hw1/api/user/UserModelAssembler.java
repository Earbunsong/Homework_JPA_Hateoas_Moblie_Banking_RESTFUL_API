package co.cstad.song.s_advance_jpa_restful_hw1.api.user;

import co.cstad.song.s_advance_jpa_restful_hw1.api.user.web.UserDto;
import co.cstad.song.s_advance_jpa_restful_hw1.api.user.web.UserRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserModelAssembler extends RepresentationModelAssemblerSupport<User, EntityModel<UserDto>> {
    private  UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserModelAssembler() {
        super(UserRestController.class,(Class<EntityModel<UserDto>>) (Class<?>)EntityModel.class);
    }


    @Override
    public EntityModel<UserDto> toModel(User entity) {
       UserDto userDto = userMapper.userToUserDto(entity);
       Link selfLink = linkTo(methodOn(UserRestController.class).findUsersByUuid(entity.getUuid())).withSelfRel();
       Link collectionLink = linkTo(methodOn(UserRestController.class).findUsers()).withRel(IanaLinkRelations.COLLECTION);
        return EntityModel.of(userDto, selfLink, collectionLink);
    }
    @Override
    public CollectionModel<EntityModel<UserDto>> toCollectionModel(Iterable<? extends User> entities) {
        return super.toCollectionModel(entities);
    }
}
