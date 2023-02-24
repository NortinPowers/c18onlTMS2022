package by.tms.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@ToString
public class FuelTank implements Serializable {

    private String fuelType;
    private transient int capacity;
}
