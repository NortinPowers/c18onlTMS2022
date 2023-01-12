package by.tms;

import by.tms.service.ToyService;
import by.tms.service.ToyServiceAware;

public class MainTask3 {
    public static void main(String[] args) {
        ToyServiceAware toyService = new ToyService();
        System.out.println(toyService.getToyNames());
        System.out.println(toyService.getToys());
        System.out.println(toyService.getToyInfo());
    }
}