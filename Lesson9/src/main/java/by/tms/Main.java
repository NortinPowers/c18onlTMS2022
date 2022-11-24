package by.tms;

import by.tms.utils.Seasons;

import static by.tms.utils.Seasons.AUTUMN;
import static by.tms.utils.Seasons.getPreferences;

public class Main {
    public static void main(String[] args) {
        Seasons currentSeason = AUTUMN;
        System.out.println("It`s " + currentSeason +
                " now (№" + AUTUMN.ordinal() + ") Average temperature is "
                + currentSeason.getAverageTemperature() + " degrees");
        System.out.println(getPreferences(AUTUMN));
        Seasons[] seasons = Seasons.values();
        for (Seasons season : seasons) {
            System.out.println(season.getSeasonInfo());
            System.out.println(season.getDescription());
        }

    }
}

/*
 * Задача1: Времена года
 * 1) Создать перечисление(enum), содержащее названия времен года.
 * 2) Создать переменную содержащую ваше любимое время года и распечатать всю информацию о нем.
 * 3) Создать метод, который принимает на вход переменную созданного вами enum типа.
 * Если значение равно Лето, выводим на консоль “Я люблю лето” и так далее. Используем оператор switch.
 * 4) Перечисление должно содержать переменную, содержащую среднюю температуру в каждом времени года.
 * 5) Добавить конструктор принимающий на вход среднюю температуру.
 * 6) Создать метод getDescription, возвращающий строку “Холодное время года”.
 * Переопределить метод getDescription - для константы Лето метод должен возвращать “Теплое время года”.
 * 7) В цикле распечатать все времена года, среднюю температуру и описание времени года.
 */