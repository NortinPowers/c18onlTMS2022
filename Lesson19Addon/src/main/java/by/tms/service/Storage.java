package by.tms.service;

import by.tms.model.HeavyBox;
import by.tms.utils.WeightFilters;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static by.tms.utils.WeightFilters.EQUAL;
import static by.tms.utils.WeightFilters.GREATER;

@Getter
@ToString
public class Storage implements BoxSorterAware {

    private List<HeavyBox> heavyBoxes;

    public Storage(List<HeavyBox> heavyBoxes) {
        if (heavyBoxes == null) {
            heavyBoxes = new ArrayList<>();
        }
        this.heavyBoxes = heavyBoxes;
    }

    public Storage() {
        init();
    }

    @Override
    public List<HeavyBox> getHeavyBoxesFromWeight(Integer weight, Enum<WeightFilters> filter) {
        Predicate<HeavyBox> boxPredicate;
        if (filter == GREATER) {
            boxPredicate = heavyBox -> heavyBox.getWeight() > weight;
        } else if (filter == EQUAL) {
            boxPredicate = heavyBox -> Objects.equals(heavyBox.getWeight(), weight);
        } else {
            boxPredicate = heavyBox -> heavyBox.getWeight() < weight;
        }
        return heavyBoxes.stream()
                         .filter(boxPredicate)
                         .toList();
    }

    private void init() {
        heavyBoxes = new ArrayList<>();
        heavyBoxes.add(new HeavyBox(300));
        heavyBoxes.add(new HeavyBox(400));
        heavyBoxes.add(new HeavyBox(500));
        heavyBoxes.add(new HeavyBox(600));
        heavyBoxes.add(new HeavyBox(700));
        heavyBoxes.add(new HeavyBox(800));
        heavyBoxes.add(new HeavyBox(900));
        heavyBoxes.add(new HeavyBox(1000));
        heavyBoxes.add(new HeavyBox(3000));
    }
}