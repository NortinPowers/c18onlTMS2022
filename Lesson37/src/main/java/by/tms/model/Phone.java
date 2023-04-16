package by.tms.model;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@ToString
public class Phone {
    @Value("${price}")
    private final String price = "200";
}