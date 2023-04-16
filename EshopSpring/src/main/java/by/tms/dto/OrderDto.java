package by.tms.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

@EqualsAndHashCode
@Builder
@Getter
public class OrderDto {

    private String id;
    private LocalDate date;
    private Long userId;
}