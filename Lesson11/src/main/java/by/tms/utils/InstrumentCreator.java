package by.tms.utils;

import by.tms.interfaces.InstrumentAware;
import by.tms.model.instrument.Drum;
import by.tms.model.instrument.Guitar;
import by.tms.model.instrument.Trumpet;
import lombok.experimental.UtilityClass;

@UtilityClass
public class InstrumentCreator {

    public static InstrumentAware createInstrument(InstrumentAware.InstrumentType instrumentType, int instrumentParam) {
        if (instrumentType.name().equalsIgnoreCase("guitar")) {
            return new Guitar(instrumentParam);
        }
        if (instrumentType.name().equalsIgnoreCase("drum")) {
            return new Drum(instrumentParam);
        }
        if (instrumentType.name().equalsIgnoreCase("trumpet")) {
            return new Trumpet(instrumentParam);
        }
        return null;
    }
}
