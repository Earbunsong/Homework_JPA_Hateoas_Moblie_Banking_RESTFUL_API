package co.cstad.song.s_advance_jpa_restful_hw1.api.accounts;

import co.cstad.song.s_advance_jpa_restful_hw1.api.accounts.web.CreateAccountDto;
import co.cstad.song.s_advance_jpa_restful_hw1.api.accounts.web.RenameDto;
import co.cstad.song.s_advance_jpa_restful_hw1.api.accounts.web.TransferLimitDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface AccountService {

    EntityModel<?> Create(CreateAccountDto createAccountDto);
    String disable(String uuid);
    CollectionModel<?> findAll();
    EntityModel<?> findByAccountUuid(String uuid);
    EntityModel<?> renameAccountByUuid(String uuid, RenameDto  renameDto);

    EntityModel<?> TransferLimitByUuid(String uuid, TransferLimitDto transferLimit);
}
