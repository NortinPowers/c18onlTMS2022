package by.tms.model.figures;

import by.tms.service.interfaces.AreaOfFigureCalculable;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Triangle extends Figure implements AreaOfFigureCalculable {
    private double sideA;
    private double sideB;
    private double sideC;

    /**
     * The method gives the square of a triangle
     */
    @Override
    public double getSquare() {
        if (getConditionForExistenceOfTriangle()) {
            double semiPerimeter = getSemiPerimeter();
            return Math.sqrt(semiPerimeter * (semiPerimeter - getSideA()) * (semiPerimeter - getSideB()) * (semiPerimeter - getSideC()));
        } else {
            return 0;
        }
    }

    /**
     * The method gives the simi perimeter of a triangle
     */
    private double getSemiPerimeter() {
        return (getSideA() + getSideB() + getSideC()) / 2;
    }

    /**
     * The method gives the condition for the existence of a triangle
     */
    public boolean getConditionForExistenceOfTriangle() {
        return getSideA() + getSideB() > getSideC() && getSideB() + getSideC() > getSideA() && getSideC() + getSideA() > getSideB();
    }

    /**
     * The method returns a message about the impossibility of the existence of a triangle with the specified sides
     */
    public String getCannotExistConditionMessage() {
        return "a triangle with sides " + sideA + ", " + sideB + ", " + sideC + " cannot exist";
    }
}
