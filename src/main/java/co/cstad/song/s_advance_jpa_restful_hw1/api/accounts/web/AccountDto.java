package co.cstad.song.s_advance_jpa_restful_hw1.api.accounts.web;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record AccountDto(String uuid,
                         String actNo,
                         String actName,
                         String  transferLimit) {
}
