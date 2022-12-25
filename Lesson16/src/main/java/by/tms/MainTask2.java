package by.tms;

import by.tms.model.Cat;
import by.tms.model.Generalization;
import by.tms.service.GeneralizationService;

public class MainTask2 {
    public static void main(String[] args) {
        GeneralizationService generalizationService = new GeneralizationService(new Generalization("test", new Cat(), 0.3));
        System.out.println(generalizationService.getVariablesNameInfo());
    }
}