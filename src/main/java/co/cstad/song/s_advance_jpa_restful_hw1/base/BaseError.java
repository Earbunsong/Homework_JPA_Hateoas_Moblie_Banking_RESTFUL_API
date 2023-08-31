package co.cstad.song.s_advance_jpa_restful_hw1.base;

import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public record BaseError<T>(Boolean isSuccess,
                        String message,
                        Integer code,
                        LocalDateTime timestamp,
                        T errors) {
}
