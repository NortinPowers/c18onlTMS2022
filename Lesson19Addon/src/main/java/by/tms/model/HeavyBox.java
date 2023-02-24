package by.tms.model;

import static by.tms.utils.Constants.EMPTY_BOX_WEIGHT;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HeavyBox {

    private Integer weight;

    public HeavyBox(Integer weight) {
        getAllowedWeight(weight);
    }

    public void setWeight(Integer weight) {
        getAllowedWeight(weight);
    }

    private void getAllowedWeight(Integer weight) {
        if (weight < EMPTY_BOX_WEIGHT) {
            this.weight = EMPTY_BOX_WEIGHT;
        } else {
            this.weight = weight;
        }
    }
}