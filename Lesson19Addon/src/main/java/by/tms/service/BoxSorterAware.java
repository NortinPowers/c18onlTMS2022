package by.tms.service;

import by.tms.model.HeavyBox;
import by.tms.utils.WeightFilter;

import java.util.List;

public interface BoxSorterAware {
    List<HeavyBox> getHeavyBoxesFromWeight(Integer weight, Enum<WeightFilter> filter);
}