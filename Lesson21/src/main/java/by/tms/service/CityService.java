package by.tms.service;

import by.tms.model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.tms.utils.CRUDUtils.deleteById;
import static by.tms.utils.CRUDUtils.updateOneParameterById;
import static by.tms.utils.DBUtils.getConnection;

public class CityService {
    private static final String GET_ALL_CITIES_QUERY = "select * from cities order by cities.id";
    private static final String GET_CURRENT_CITY_QUERY = "select * from cities where cities.name = ?";
    private static final String GET_CITY_BY_ID_QUERY = "select id from cities where cities.name = ?";
    private static final String INSERT_CITIES_QUERY = "insert into cities(name, info) values(?, ?);";
    private static final String UPDATE_CITIES_QUERY = "update cities set info = ? where id = ?;";
    private static final String DELETE_CITIES_QUERY = "delete from cities where id = ?";

    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_CITIES_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String info = resultSet.getString("info") == null ? "no information available" : resultSet.getString("info");
                cities.add(new City(id, name, info));
            }
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return cities;
    }

    public void addNewCity(City city) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(INSERT_CITIES_QUERY);
            statement.setString(1, city.getName());
            statement.setString(2, city.getInfo());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public void updateCity(Long id, String info) {
        updateOneParameterById(id, info, UPDATE_CITIES_QUERY);
    }

    public void deleteCity(Long id) {
        deleteById(id, DELETE_CITIES_QUERY);
    }

    public City findCityByName(String name) {
        City city = null;
        try (Connection connection = getConnection()) {
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

    public Long getCityId(String name) {
        long id = -1L;
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_CITY_BY_ID_QUERY);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getLong("id");
            }
        } catch (SQLException e) {
            System.out.println("Exception 1: " + e.getMessage());
        }
        return id;
    }
}