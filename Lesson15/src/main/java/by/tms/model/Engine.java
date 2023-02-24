package by.tms.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@ToString
public class Engine implements Serializable {

    private String engineType;
    private int numberOfCylinders;
}
