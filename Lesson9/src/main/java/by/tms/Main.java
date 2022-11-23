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
 * <p>
 * <p>
 * Задача2: Цветочный магазин.
 * Создать класс "Flower", который содержит переменные имя и стоимость, гет сет и toString (lombok подключаем)
 * Необходимо:
 * 1) собрать 5 букетов (используем массив) с определением их стоимости, т.е создаем класс Bouquet,
 * который содержит массив объектов Flower, который инициализируется через конструктор, а также метод по вычислению стоимости.
 * 2) вывести на консоль информацию по каждому букету.
 * 3*звездочка) Подсчитать количество всех проданных цветов.
 * Пояснения решения:
 * Создать класс FlowerMarket, который содержит метод public Bouquet getBouquet(String... flowers),
 * Создать enum FlowerType c константами названия цветов.
 * Для создания букета в метод getBouquet нужно передавать константы через запятую(ROSE, ROSE, ROSE, ROSE, ROSE)
 * По названию константы enam создать объект класса Flower и поместить в массив,
 * для передачи его в класс букета.
 * Также в енам константах необходимо создать переменную cost(стоимость) типа int и прописать стоимость каждого цветка, гет, сет, конструктор!
 * ROSE - 15
 * LILY - 7
 * ASTER - 5
 * HERBERA - 5
 * TULIP - 8
 * CARNATION - 11
 */