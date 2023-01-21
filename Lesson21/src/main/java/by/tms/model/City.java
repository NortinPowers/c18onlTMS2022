package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class City {
    private Long id;
    private String name;
    private String info;

    public City(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public City(String name) {
        this.name = name;
    }
}