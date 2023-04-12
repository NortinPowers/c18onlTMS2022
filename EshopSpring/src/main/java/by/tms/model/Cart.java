package by.tms.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

//@AllArgsConstructor
@Getter
@EqualsAndHashCode
//@NoArgsConstructor
@Builder
public class Cart {

    private Long id;
    private Long userId;
    private Long productId;
    private boolean cart;
    private boolean favorite;
    private Integer count;
}