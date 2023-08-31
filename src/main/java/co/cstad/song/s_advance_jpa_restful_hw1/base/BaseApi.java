package co.cstad.song.s_advance_jpa_restful_hw1.base;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Builder
public record BaseApi<T>(Boolean isSuccess,
                      Integer code,
                      String message,
                      Boolean status,
                      LocalDateTime timestamp,
                      T data) {
}
