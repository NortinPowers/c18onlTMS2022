package by.tms.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

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

    public Order(LocalDate date, Long userId, Integer productsCount) {
        this.date = date;
        this.userId = userId;
        this.productsCount = productsCount;
    }
}