package by.tms.model.figures;

import by.tms.model.Figures;
import by.tms.service.interfaces.AreaOfFigureCalculable;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import static by.tms.model.Figures.RECTANGLE;

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

    @Override
    public Figures getType() {
        return RECTANGLE;
    }
}
