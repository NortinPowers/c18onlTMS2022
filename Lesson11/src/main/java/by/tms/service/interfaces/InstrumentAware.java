package by.tms.service.interfaces;

public interface InstrumentAware {
    String KEY = "До мажор";

    enum InstrumentType {
        GUITAR,
        DRUM,
        TRUMPET
    }

    String play();
}
