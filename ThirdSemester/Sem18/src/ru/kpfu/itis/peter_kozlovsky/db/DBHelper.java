package ru.kpfu.itis.peter_kozlovsky.db;

import ru.kpfu.itis.peter_kozlovsky.db.model.User;
import ru.kpfu.itis.peter_kozlovsky.db.repository.*;
import ru.kpfu.itis.peter_kozlovsky.hash.SHA256;
import ru.kpfu.itis.peter_kozlovsky.hash.SlowHasher;
import ru.kpfu.itis.peter_kozlovsky.singleton.ConnectionSingleton;

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
    public static AutoBrandRepository autoBrandRepository = new AutoBrandRepository();
    public static AutoModelRepository autoModelRepository = new AutoModelRepository();
    public static AutoSubmodelRepository autoSubmodelRepository = new AutoSubmodelRepository();
    public static AutoModifyRepository autoModifyRepository = new AutoModifyRepository();
    public static AdRepository adRepository = new AdRepository();

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
        return "bad_pwd";
    }

    public static int getNewsCount(byte type) {
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM templates WHERE type = ?");
            preparedStatement.setByte(1, type);
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
        } finally {
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
