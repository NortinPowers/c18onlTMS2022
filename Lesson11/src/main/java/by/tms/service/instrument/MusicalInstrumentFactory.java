package by.tms.service.instrument;

import by.tms.model.instrument.Drum;
import by.tms.model.instrument.Guitar;
import by.tms.model.instrument.Trumpet;
import by.tms.service.interfaces.InstrumentAware;
import org.jetbrains.annotations.NotNull;

public class MusicalInstrumentFactory {

    public InstrumentAware createInstrument(InstrumentAware.@NotNull InstrumentType instrumentType, int instrumentParam) {
        return switch (instrumentType) {
            case DRUM -> new Drum(instrumentParam);
            case GUITAR -> new Guitar(instrumentParam);
            case TRUMPET -> new Trumpet(instrumentParam);
        };
    }
}
