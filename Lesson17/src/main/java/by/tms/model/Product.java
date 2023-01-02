package by.tms.model;

import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product<N extends Number> implements Comparable<Product> {
    private final long id;
    private String name;
    private N price;

    @Override
    public int compareTo(@NonNull Product product) {
        double result = this.getPrice().doubleValue() - (product.getPrice().doubleValue());
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product<?> product = (Product<?>) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public long getId() {
        return id;
    }
}