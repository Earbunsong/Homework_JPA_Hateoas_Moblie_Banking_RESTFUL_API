package co.cstad.song.s_advance_jpa_restful_hw1.api.accountype;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface AccountTypeService {
    CollectionModel<?> findAllAccountType();
    EntityModel<?> findAccountTypeById(Long id);
}
