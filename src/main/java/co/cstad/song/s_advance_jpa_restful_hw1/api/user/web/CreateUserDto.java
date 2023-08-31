package co.cstad.song.s_advance_jpa_restful_hw1.api.user.web;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CreateUserDto( Long id,
                             String uuid,
                            @NotBlank @Size(min = 6,max = 25)
                            String name,
                            @NotBlank
                            String gender,
                            @NotBlank
                                    @Email
                            String email,
                            @NotBlank
                            @Size(min = 8, max = 25)
                            String password,
                            @NotBlank
                             Integer phoneNumber,
                            @NotNull
                             Boolean isStudent,
                             Boolean studentCardNo,
                             Boolean isDeleted,
                             String verifiedCode,
                            @NotBlank
                            List<Integer> roleIds) {
}
