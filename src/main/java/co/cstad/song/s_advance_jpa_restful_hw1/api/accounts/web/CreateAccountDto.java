package co.cstad.song.s_advance_jpa_restful_hw1.api.accounts.web;

import co.cstad.song.s_advance_jpa_restful_hw1.api.accountype.AccountType;
import lombok.Builder;

@Builder
public record CreateAccountDto(String actName,
                               String actNo,
                               String uuid,
                               String pin,
                               String  transferLimit,
                               AccountType accountTypeId) {
}
