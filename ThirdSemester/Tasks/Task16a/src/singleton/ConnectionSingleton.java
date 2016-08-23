package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Birthright on 16.10.2015.
 */
public class ConnectionSingleton {
    public static Connection getStatement() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/MyBase", "postgres", "root");
        } catch (final ClassNotFoundException | SQLException e) {
            return null;
        }
    }
}
