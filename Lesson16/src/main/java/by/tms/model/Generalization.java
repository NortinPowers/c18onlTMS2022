package by.tms.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Generalization<T extends Comparable<String>, V extends Animal & Serializable, K extends Number> {

    private final T t;
    private final V v;
    private final K k;
}