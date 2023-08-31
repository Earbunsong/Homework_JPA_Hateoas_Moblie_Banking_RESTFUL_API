package co.cstad.song.s_advance_jpa_restful_hw1.api.user.web;

import co.cstad.song.s_advance_jpa_restful_hw1.api.accounts.UserAccount;
import co.cstad.song.s_advance_jpa_restful_hw1.api.user.UserRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.List;

@Builder
public record UserDto(String uuid,
                      String name,
                      String gender,
                      String email,
                      String phoneNumber,
                      Boolean isStudent,
                      Boolean isDeleted,
                      Boolean isVerified,
                      @JsonInclude(value = JsonInclude.Include.NON_NULL)
                      String studentCardNo,
                      List<UserRole> userRoles,
                      List<UserAccount> userAccounts) {
}