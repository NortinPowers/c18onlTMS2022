package by.tms.service;

import by.tms.model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.tms.utils.CRUDUtils.deleteById;
import static by.tms.utils.CRUDUtils.updateOneParameterById;
import static by.tms.utils.DBUtils.getConnection;

public class CityService {
    private static final String GET_ALL_CITIES_QUERY = "SELECT * FROM cities ORDER BY cities.id";
    private static final String INSERT_CITIES_QUERY = "INSERT INTO cities(name, info) VALUES(?, ?);";
    private static final String UPDATE_CITIES_QUERY = "UPDATE cities SET info = ? WHERE id = ?;";
    private static final String DELETE_CITIES_QUERY = "DELETE FROM cities WHERE id = ?";

    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_CITIES_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
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

    public void updateCity(Integer id, String info) {
        updateOneParameterById(id, info, UPDATE_CITIES_QUERY);
    }

    public void deleteCity(Integer id) {
        deleteById(id, DELETE_CITIES_QUERY);
    }

    public City findCityByName(String name) {
        Optional<City> optionalCity = getOptionalCity(name);
        return optionalCity.orElse(null);
    }

    public Optional<City> getOptionalCity(String name) {
        return getAllCities().stream()
                .filter(city -> city.getName().equals(name))
                .findAny();
    }
}