package co.cstad.song.s_advance_jpa_restful_hw1.api.accountype;

import co.cstad.song.s_advance_jpa_restful_hw1.api.accountype.web.AccountTypeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountTypeMapper {
    AccountTypeDto mapAccountTypeToDto(AccountType accountType);
}