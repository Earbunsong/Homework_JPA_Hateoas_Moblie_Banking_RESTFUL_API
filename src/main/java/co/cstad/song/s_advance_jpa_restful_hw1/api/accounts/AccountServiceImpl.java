package co.cstad.song.s_advance_jpa_restful_hw1.api.accounts;

import co.cstad.song.s_advance_jpa_restful_hw1.api.accounts.web.CreateAccountDto;
import co.cstad.song.s_advance_jpa_restful_hw1.api.accounts.web.RenameDto;
import co.cstad.song.s_advance_jpa_restful_hw1.api.accounts.web.TransferLimitDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final AccountModelAssembler accountModelAssembler;
    private final AccountMapper accountMapper;

    @Override
    public EntityModel<?> Create(CreateAccountDto createAccountDto) {
        Account account =accountMapper.accountToCreateAccount(createAccountDto);
        account.setUuid(UUID.randomUUID().toString());
        account.setActName(createAccountDto.actName());
        account.setActNo(createAccountDto.actNo());
        account.setPin(createAccountDto.pin());
        account.setTransferLimit(createAccountDto.transferLimit());
        account.setAccountType(createAccountDto.accountTypeId());
        accountRepository.save(account);
        return accountModelAssembler.toModel(account);
    }

    @Transactional
    @Override
    public String disable(String uuid){
       Optional<Account> optionalAccount = accountRepository.findByUuid(uuid);
       if(optionalAccount.isPresent()){
           Account account = optionalAccount.get();
           accountRepository.save(account);
       }
        return null;
    }

    @Override
    public CollectionModel<?> findAll() {
        List<Account> accounts = accountRepository.findAll();
        return accountModelAssembler.toCollectionModel(accounts);
    }

    @Override
    public EntityModel<?> findByAccountUuid(String uuid) {
        Account account = accountRepository.findByUuid(uuid).orElseThrow();
        return accountModelAssembler.toModel(account);
    }

    @Override
    public EntityModel<?> renameAccountByUuid(String uuid, RenameDto renameDto) {
        Optional<Account> accountOptional = accountRepository.findByUuid(uuid);
        if(accountOptional.isPresent()){
            Account account = accountOptional.get();
            account.setActName(renameDto.actName());
            accountRepository.save(account);
            return accountModelAssembler.toModel(account);
        }throw new RuntimeException("Not found uuid");

    }

    @Override
    public EntityModel<?> TransferLimitByUuid(String uuid, TransferLimitDto transferLimit) {
        Optional<Account> accountOptional = accountRepository.findByUuid(uuid);
        if(accountOptional.isPresent()){
            Account account = accountOptional.get();
            account.setTransferLimit(transferLimit.transferLimit());
            accountRepository.save(account);
            return accountModelAssembler.toModel(account);
        }
        throw new RuntimeException("Not Found with this uuid");
    }
    }




