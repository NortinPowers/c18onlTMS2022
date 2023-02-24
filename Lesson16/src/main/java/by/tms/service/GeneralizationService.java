package by.tms.service;


import by.tms.model.Generalization;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class GeneralizationService {

    private final Generalization generalization;

    /**
     * The method returns information about the types of variables of the method
     *
     * @return String
     */
    public String getVariablesNameInfo() {
        return "T" + getClassSimpleName(generalization.getT()) +
                "V" + getClassSimpleName(generalization.getV()) +
                "K" + getClassSimpleName(generalization.getK());
    }

    /**
     * The method returns the name of the class variable
     *
     * @return String
     */
    public String getClassSimpleName(@NonNull Object t) {
        return " type: " + t.getClass().getSimpleName() + "\n";
    }
}