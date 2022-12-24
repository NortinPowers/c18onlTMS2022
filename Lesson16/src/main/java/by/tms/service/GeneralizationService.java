package by.tms.service;


import by.tms.model.Generalization;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class GeneralizationService {
    private final Generalization generalization;

    public String getVariablesName() {
        return "T" + getClassSimpleName(generalization.getT()) +
                "V" + getClassSimpleName(generalization.getV()) +
                "K" + getClassSimpleName(generalization.getK());
    }

    public String getClassSimpleName(@NonNull Object t) {
        return " type: " + t.getClass().getSimpleName() + "\n";
    }
}