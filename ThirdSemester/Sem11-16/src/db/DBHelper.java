package db;

import db.model.User;
import db.repository.TemplateRepositoryImlp;
import db.repository.UserRepositoryImpl;
import hash.SHA256;
import hash.SlowHasher;
import singleton.ConnectionSingleton;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Birthright on 18.10.2015.
 */
public class DBHelper {
    public static UserRepositoryImpl userRepository = new UserRepositoryImpl();
    public static TemplateRepositoryImlp newsRepository = new TemplateRepositoryImlp();

    public static String checkUser(String login, String password) {
        User user = userRepository.getUser(login);
        if (user == null) {
            return "bad_login";
        }
        byte[] salt = user.getSalt();

        if (new String(new SlowHasher().calculateSlowHash(new SHA256(), password, salt),
                StandardCharsets.UTF_8).equals(user.getPassword())) {

            return "OK";
        }
        System.out.println("kok");
        return "bad_pwd";

    }

    public static int getNewsCount() {
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM templates");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Integer.parseInt(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public static Boolean checkRegistration(String login) {
        User user = userRepository.getUser(login);
        return user != null;
    }

    public static void addViewsForPage(Integer id) {
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("UPDATE templates SET views = (views + 1) where id = ? ");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
