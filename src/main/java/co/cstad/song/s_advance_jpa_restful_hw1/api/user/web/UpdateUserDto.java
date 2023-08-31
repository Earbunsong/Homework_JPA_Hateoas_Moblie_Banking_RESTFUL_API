package co.cstad.song.s_advance_jpa_restful_hw1.api.user.web;

import lombok.Builder;

import java.util.List;
@Builder
public record UpdateUserDto(String uuid,
                            String name,
                            String password,
                            String email,
                            String phoneNumber,
                            Boolean isDelete,
                            Boolean isStudent,
                            Boolean isVerified

) {
}
