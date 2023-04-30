package by.tms.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;

@EqualsAndHashCode
@Builder
@Getter
@Scope("session")
public class OrderDto {

    private String id;
    private LocalDate date;
    private Long userId;
}