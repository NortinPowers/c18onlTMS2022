package by.tms.service;

import by.tms.model.figures.Figure;
import by.tms.model.figures.Line;
import by.tms.model.figures.Rectangle;
import by.tms.model.figures.Triangle;

import static by.tms.model.Figures.*;

public class Task4 {
    public static void main(String[] args) {
        Figure[] figures = new Figure[4];
        figures[0] = Line.builder()
                .build();
        figures[1] = Triangle.builder()
                .sideA(5)
                .sideB(6)
                .sideC(8)
                .build();
        figures[2] = Rectangle.builder()
                .sideA(12)
                .sideB(15)
                .build();
        figures[3] = Triangle.builder()
                .sideA(2)
                .sideB(2)
                .sideC(8)
                .build();
        for (Figure figure : figures) {
            if (figure.getType() == LINE) {
                System.out.println(LINE.getSquareInfo());
            } else if (figure.getType() == TRIANGLE) {
                if (((Triangle) figure).getConditionForExistenceOfTriangle()) {
                    System.out.printf("%s%.2f\n", TRIANGLE.getSquareInfo(), ((Triangle) figure).getSquare());
                } else {
                    System.out.printf(((Triangle) figure).getCannotExistConditionMessage());
                }
            } else if (figure.getType() == RECTANGLE) {
                System.out.println(RECTANGLE.getSquareInfo() + ((Rectangle) figure).getSquare());
            }
        }
    }
}
