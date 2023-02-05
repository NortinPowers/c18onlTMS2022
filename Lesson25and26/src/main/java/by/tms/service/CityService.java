package by.tms.service;

import by.tms.model.City;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
public class CityService {
    private Connection connection;
    private static final String GET_CURRENT_CITY_QUERY = "select * from cities where cities.name = ?";
    private static final String GET_CITY_ID_BY_NAME_QUERY = "select id from cities where cities.name = ?";
    private static final String INSERT_CITIES_QUERY = "insert into cities(name, info) values(?, ?);";

    public void addNewCity(City city) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_CITIES_QUERY);
            statement.setString(1, city.getName());
            statement.setString(2, city.getInfo());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public City findCityByName(String name) {
        City city = null;
        try {
            PreparedStatement statement = connection.prepareStatement(GET_CURRENT_CITY_QUERY);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String cityName = resultSet.getString("name");
                if (!cityName.isEmpty()) {
                    city = new City(name);
                }
            }
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return city;
    }

    public Long getCityIdByName(String name) {
        try {
            PreparedStatement statement = connection.prepareStatement(GET_CITY_ID_BY_NAME_QUERY);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getLong("id");
            }
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
}