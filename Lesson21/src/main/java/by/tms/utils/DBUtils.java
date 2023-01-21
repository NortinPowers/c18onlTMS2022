package by.tms.utils;

import lombok.experimental.UtilityClass;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass
public class DBUtils {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "root";
    public static final String SCRIPT_FILE_ADDRESS = "Lesson21/src/main/resources/scripts/create_and_fill_tables.sql";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection exception: " + e.getMessage());
        }
        return connection;
    }

    public static void createAndFillTablesByScript(String scriptFileAddress) {
        Connection connection = getConnection();
        ScriptRunner sr = new ScriptRunner(connection);
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader(scriptFileAddress));
        } catch (FileNotFoundException e) {
            System.out.println("Exc: " + e.getMessage());
        }
        sr.runScript(reader);
    }
}