package by.tms.service;

import by.tms.interfaces.InstrumentAware;
import by.tms.utils.InstrumentCreator;

import static by.tms.interfaces.InstrumentAware.InstrumentType.*;

public class Task1 {
    public static void main(String[] args) {
        InstrumentAware[] instruments = new InstrumentAware[3];
        instruments[0] = InstrumentCreator.createInstrument(GUITAR, 6);
        instruments[1] = InstrumentCreator.createInstrument(DRUM, 50);
        instruments[2] = InstrumentCreator.createInstrument(TRUMPET, 15);
        for (InstrumentAware instrument : instruments) {
            System.out.println(instrument.play());
        }
    }
}
