package by.tms.eshop.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Builder
public class Cart {

    private Long id;
    private Long userId;
    private Long productId;
    private boolean cart;
    private boolean favorite;
    private Integer count;
}