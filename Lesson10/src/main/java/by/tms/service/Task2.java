package by.tms.service;

import by.tms.model.People;
import by.tms.model.clothes.*;

public class Task2 {

    public static void main(String[] args) {
        People peopleTom = People.builder()
                                 .name("Tom")
                                 .jacket(new BossJacket())
                                 .pants(new TopmanPants())
                                 .shoes(new FilaShoes())
                                 .build();
        People peopleKate = People.builder()
                                  .name("Kate")
                                  .jacket(new HollisterJacket())
                                  .pants(new VersacePants())
                                  .shoes(new PumaShoes())
                                  .build();
        System.out.println(peopleKate.undressing());
        System.out.println(peopleTom.dressingUp());
    }
}
