package by.tms.service;

import by.tms.model.HeavyBox;
import by.tms.utils.WeightFilters;
import java.util.List;

public interface BoxSorterAware {

    List<HeavyBox> getHeavyBoxesFromWeight(Integer weight, Enum<WeightFilters> filter);
}