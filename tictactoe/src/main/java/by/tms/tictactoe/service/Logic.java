package by.tms.tictactoe.service;

import by.tms.tictactoe.model.Figure;

public class Logic {

    private final Figure[][] table;

    public Logic(Figure[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        //реализовать логику по проверке, что 3 крестика в одной строке или столбце или по диагонали
        return false;
    }

    public boolean isWinnerO() {
        //реализовать логику по проверке, что 3 нолика в одной строке или столбце или по диагонали
        return false;
    }

    /**
     * Метод проверки, есть ли пустая клетка на поле(т.е не стоит X и не стоит O)
     *
     * @return true - если есть хотя бы одна свободная клетка, иначе все поля заполнены
     */
    public boolean checkEmptyCells() {
        for (Figure[] figures : table) {
            for (Figure figure : figures) {
                if (!figure.hasMarkX() && !figure.hasMarkO()) {
                    return true;
                }
            }
        }
        return false;
    }
}
