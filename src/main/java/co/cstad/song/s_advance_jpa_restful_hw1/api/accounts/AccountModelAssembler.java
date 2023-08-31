package co.cstad.song.s_advance_jpa_restful_hw1.api.accounts;

import co.cstad.song.s_advance_jpa_restful_hw1.api.accounts.web.AccountDto;
import co.cstad.song.s_advance_jpa_restful_hw1.api.accounts.web.AccountRestController;
import co.cstad.song.s_advance_jpa_restful_hw1.api.user.web.UserDto;
import co.cstad.song.s_advance_jpa_restful_hw1.api.user.web.UserRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AccountModelAssembler extends RepresentationModelAssemblerSupport<Account, EntityModel<AccountDto>> {
    private AccountMapper accountMapper;

    @Autowired
    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    public AccountModelAssembler() {
        super(AccountRestController.class,(Class<EntityModel<AccountDto>>) (Class<?>)EntityModel.class);
    }

    public EntityModel<AccountDto> toModel(Account entity) {
        AccountDto accountDto = accountMapper.mapAccountToAccountDto(entity);
        Link link = linkTo(methodOn(AccountRestController.class).findAccountById(entity.getUuid())).withSelfRel();
        Link link1 = linkTo(methodOn(AccountRestController.class).findAccount()).withRel(IanaLinkRelations.COLLECTION);
        return EntityModel.of(accountDto,link,link1);
    }

    @Override
    public CollectionModel<EntityModel<AccountDto>> toCollectionModel(Iterable<? extends Account> entities) {
        return super.toCollectionModel(entities);
    }
}
