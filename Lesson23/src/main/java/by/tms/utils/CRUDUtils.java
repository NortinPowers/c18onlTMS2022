package by.tms.utils;

import static by.tms.utils.DBUtils.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CRUDUtils {

    public static void updateOneParameterById(Long id, String parameter, String updateQuery) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(updateQuery);
            statement.setString(1, parameter);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static void deleteById(Long id, String deleteQuery) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(deleteQuery);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}