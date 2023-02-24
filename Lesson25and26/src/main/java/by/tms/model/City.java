package by.tms.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class City implements Serializable {

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