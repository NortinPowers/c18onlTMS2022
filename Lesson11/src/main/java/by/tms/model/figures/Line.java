package by.tms.model.figures;

import static by.tms.model.Figures.LINE;

import by.tms.model.Figures;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Line extends Figure {

    @Override
    public Figures getType() {
        return LINE;
    }
}
