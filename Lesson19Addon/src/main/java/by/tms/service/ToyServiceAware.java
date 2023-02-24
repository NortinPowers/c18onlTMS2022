package by.tms.service;

import by.tms.model.Toy;

import java.util.List;

public interface ToyServiceAware {

    List<String> getToyNames();

    List<Toy> getToys();

    String getToyInfo();
}