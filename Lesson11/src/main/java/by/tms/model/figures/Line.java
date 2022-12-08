package by.tms.model.figures;

import by.tms.model.Figures;
import lombok.experimental.SuperBuilder;

import static by.tms.model.Figures.LINE;

@SuperBuilder
public class Line extends Figure {
    @Override
    public Figures getType() {
        return LINE;
    }
}
