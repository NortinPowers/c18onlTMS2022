package by.tms.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Seasons {
    SPRING(14.5) {
        final double averageTemperature = getAverageTemperature();
        final String seasonDescription = "Spring is the most pleasant of all the seasons of the year.\n" +
                "The weather is getting warmer and warmer, everything changes and seems to revive.\n" +
                "The trees begin to bud. Sometimes it rains, but there are no rough winds; the sun shines brightly.\n" +
                "The grass is green and one can see a lot of flowers peeping out from it.\n" +
                "In spring all the migratory birds return. They sing sweetly on the branches of the trees.";

        public String getSeasonInfo() {
            return seasonDescription + " The average temperature is " + averageTemperature + " degrees";
        }
    },
    SUMMER(19.5) {
        final double averageTemperature = getAverageTemperature();
        final String seasonDescription = "Summer is the hottest season of the year. The days are longest in summer.\n" +
                "The longest day of the year is the 22nd of June. Some people like summer best of all.\n" +
                "All of us enjoy summer with its cloudless sunshine, with its gardens and meadows full of flowers.\n" +
                "There is a lot of fruit and vegetables at that time. \n" +
                "In summer many people leave town and spend the hottest time in the country or at the seaside.";

        public String getSeasonInfo() {
            return seasonDescription + " The average temperature is " + averageTemperature + " degrees";
        }

        public String getDescription() {
            return "Warm season";
        }
    },
    AUTUMN(8) {
        final double averageTemperature = getAverageTemperature();
        final String seasonDescription = "Autumn is the season of fruit and vegetables. \n" +
                "But the days become shorter and the nights longer and darker. \n" +
                "The weather is not so good as in spring and in summer. \n" +
                "It often rains and the air gets colder and colder.";

        public String getSeasonInfo() {
            return seasonDescription + " The average temperature is " + averageTemperature + " degrees";
        }
    },
    WINTER(-6) {
        final double averageTemperature = getAverageTemperature();
        final String seasonDescription = "Winter is the coldest season of the year. The winter months are December,\n" +
                "January and February. The winter days are short and gloomy. It often snows and it freezes.\n" +
                "Winter is a very beautiful season too. Some people like it very much.\n" +
                "It is pleasant to walk when it is not very cold and it snows. The ground is covered with snow.\n" +
                "The trees and the roofs are white with snow too.\n" +
                "Winter also gives great opportunities for those who go m for winter sports.";

        public String getSeasonInfo() {
            return seasonDescription + " The average temperature is " + averageTemperature + " degrees";
        }
    };

    private final double averageTemperature;

    public abstract String getSeasonInfo();

    public String getDescription() {
        return "Cold season";
    }

    public static String getPreferences(Seasons seasons) {
        String preferences = "";
        switch (seasons) {
            case SUMMER:
                preferences = "I like " + SUMMER.name().toLowerCase();
                break;
            case WINTER:
                preferences = "I like " + WINTER.name().toLowerCase();
                break;
            case SPRING:
                preferences = "I like " + SPRING.name().toLowerCase();
                break;
            case AUTUMN:
                preferences = "I like " + AUTUMN.name().toLowerCase();
                break;
            default:
                break;
        }
        return preferences;
    }
}


