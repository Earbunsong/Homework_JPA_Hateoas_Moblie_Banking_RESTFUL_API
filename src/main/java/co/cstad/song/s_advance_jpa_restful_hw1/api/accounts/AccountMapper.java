package co.cstad.song.s_advance_jpa_restful_hw1.api.accounts;

import co.cstad.song.s_advance_jpa_restful_hw1.api.accounts.web.AccountDto;
import co.cstad.song.s_advance_jpa_restful_hw1.api.accounts.web.CreateAccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account accountToCreateAccount(CreateAccountDto createAccountDto);
//    List<AccountDto> mapListAccountToListAccountDto(List<Account> accounts);
    AccountDto mapAccountToAccountDto(Account account);


}
