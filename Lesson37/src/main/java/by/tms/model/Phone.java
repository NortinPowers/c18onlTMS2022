package by.tms.model;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@ToString
@RequiredArgsConstructor
public class Phone {
    @Value("${price}")
    private final String price;
}