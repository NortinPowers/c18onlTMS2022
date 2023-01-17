package by.tms.utils;

import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static by.tms.utils.DBUtils.getConnection;

@UtilityClass
public class CRUDUtils {
    public static void updateOneParameterById(Integer id, String parameter, String updateQuery) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(updateQuery);
            statement.setString(1, parameter);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static void deleteById(Integer id, String deleteQuery) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(deleteQuery);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}