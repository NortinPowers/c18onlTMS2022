package by.tms.tictactoe.model;

import javafx.scene.shape.Rectangle;

public class Figure extends Rectangle {
    private boolean markX;
    private boolean markO;

    public Figure() {
    }

    public Figure(boolean markX, boolean markO) {
        this.markX = markX;
        this.markO = markO;
    }

    public void take(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    public boolean hasMarkX() {
        return markX;
    }

    public boolean hasMarkO() {
        return markO;
    }
}
