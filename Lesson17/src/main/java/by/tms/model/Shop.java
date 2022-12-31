package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
@Setter
public class Shop<E extends Product> {
    private ArrayList<E> products;
}