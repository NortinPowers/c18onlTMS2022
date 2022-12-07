package by.tms.model.figures;

import by.tms.service.interfaces.AreaOfFigureCalculable;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Rectangle extends Figure implements AreaOfFigureCalculable {
    private double sideA;
    private double sideB;

    /**
     * The method gives the square of a rectangle
     */
    @Override
    public double getSquare() {
        return sideA * sideB;
    }
}
