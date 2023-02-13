package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Cart {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private boolean cart;
    private boolean favorite;
}