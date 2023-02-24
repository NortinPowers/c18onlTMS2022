package by.tms.model.clothes;

import by.tms.interfaces.IShoes;

public class FilaShoes implements IShoes {

    @Override
    public String putOn() {
        return "put on fila shoes";
    }

    @Override
    public String takeOff() {
        return "take off fila shoes";
    }
}
