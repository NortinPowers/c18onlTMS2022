package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@SuperBuilder
@AllArgsConstructor
@ToString
public class Engine implements Serializable {
    private String engineType;
    private int numberOfCylinders;
}
