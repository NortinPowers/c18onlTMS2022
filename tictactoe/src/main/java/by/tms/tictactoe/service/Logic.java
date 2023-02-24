package by.tms.tictactoe.service;

import by.tms.tictactoe.model.Figure;

public class Logic {

    private final Figure[][] table;

    public Logic(Figure[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        for (int i = 0, j = 0; i < table.length; i++) {
            if (table[i][j].hasMarkX() && table[i][j + 1].hasMarkX() && table[i][j + 2].hasMarkX()) {
                return true;
            }
        }
        for (int i = 0, j = 0; j < table.length; j++) {
            if (table[i][j].hasMarkX() && table[i + 1][j].hasMarkX() && table[i + 2][j].hasMarkX()) {
                return true;
            }
        }
        if (table[0][0].hasMarkX() && table[1][1].hasMarkX() && table[2][2].hasMarkX()) {
            return true;
        } else {
            return table[0][2].hasMarkX() && table[1][1].hasMarkX() && table[2][0].hasMarkX();
        }
    }

    public boolean isWinnerO() {
        for (int i = 0, j = 0; i < table.length; i++) {
            if (table[i][j].hasMarkO() && table[i][j + 1].hasMarkO() && table[i][j + 2].hasMarkO()) {
                return true;
            }
        }
        for (int i = 0, j = 0; j < table.length; j++) {
            if (table[i][j].hasMarkO() && table[i + 1][j].hasMarkO() && table[i + 2][j].hasMarkO()) {
                return true;
            }
        }
        if (table[0][0].hasMarkO() && table[1][1].hasMarkO() && table[2][2].hasMarkO()) {
            return true;
        } else {
            return table[0][2].hasMarkO() && table[1][1].hasMarkO() && table[2][0].hasMarkO();
        }
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
