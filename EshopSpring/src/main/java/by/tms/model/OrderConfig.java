package by.tms.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderConfig {

    private Long id;
    private Long orderId;
    private Long productId;
}