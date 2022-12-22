package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@SuperBuilder
@AllArgsConstructor
@ToString
public class FuelTank implements Serializable {
    private String fuelType;
    private transient int capacity;
}
