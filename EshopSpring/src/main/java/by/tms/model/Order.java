package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

@EqualsAndHashCode
@AllArgsConstructor
@Builder
@Getter
public class Order {

    private String id;
    private LocalDate date;
    private Long userId;
    private Product product;
    private Integer productsCount;
}