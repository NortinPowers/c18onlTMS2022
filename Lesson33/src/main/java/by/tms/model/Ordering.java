package by.tms.model;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Ordering {

    private String order;
    private LocalDate date;
    private List<Product> products;
}