package by.tms.model.figures;

import by.tms.model.Figures;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class Figure {
    /**
     * The method returns the shape type from enum
     */
    public abstract Figures getType();
}
