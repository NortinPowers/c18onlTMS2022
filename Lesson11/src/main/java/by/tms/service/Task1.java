package by.tms.service;

import by.tms.service.instrument.MusicalInstrumentFactory;
import by.tms.service.interfaces.InstrumentAware;

import static by.tms.service.interfaces.InstrumentAware.InstrumentType.*;

public class Task1 {
    public static void main(String[] args) {
        InstrumentAware[] instruments = new InstrumentAware[3];
        MusicalInstrumentFactory instrumentFactory = new MusicalInstrumentFactory();
        instruments[0] = instrumentFactory.createInstrument(GUITAR, 6);
        instruments[1] = instrumentFactory.createInstrument(DRUM, 50);
        instruments[2] = instrumentFactory.createInstrument(TRUMPET, 15);
        for (InstrumentAware instrument : instruments) {
            System.out.println(instrument.play());
        }
    }
}
