package co.cstad.song.s_advance_jpa_restful_hw1.api.accountype;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountTypeServiceImpl implements AccountTypeService {

    private final AccountTypeRepository accountTypeRepository;
    private final AccountTypeAssembler accountTypeAssembler;

    @Override
    public CollectionModel<?> findAllAccountType() {
        List<AccountType> accountTypes = accountTypeRepository.findAll();
        return accountTypeAssembler.toCollectionModel(accountTypes);
    }

    @Override
    public EntityModel<?> findAccountTypeById(Long id) {
        AccountType accountType=accountTypeRepository.findById(id).orElseThrow();
        return accountTypeAssembler.toModel(accountType);
    }
}
