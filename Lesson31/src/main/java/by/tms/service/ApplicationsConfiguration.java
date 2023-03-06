package by.tms.service;

public class ApplicationsConfiguration {

    protected enum Race {
        ORC,
        ELF,
        HUMAN
    }

    public SquadAbstractFactory setupFactory(Race race) {
        return switch (race) {
            case ELF -> new ElfSquadFactory();
            case ORC -> new OrcSquadFactory();
            case HUMAN -> new HumanSquadFactory();
        };
    }
}