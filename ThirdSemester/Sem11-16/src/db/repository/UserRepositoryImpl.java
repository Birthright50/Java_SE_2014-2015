package db.repository;

import db.model.User;
import hash.SHA256;
import hash.SlowHasher;
import singleton.ConnectionSingleton;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Birthright on 18.10.2015.
 */
public class UserRepositoryImpl implements UserRepository {

    @Override
    public Integer createUser(User event) {
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        Integer create = -1;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO users (login, password, salt, email, region, first_name, last_name, date, year_st, gender, car_mark) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            byte[] salt = new byte[16];
            new SecureRandom().nextBytes(salt);
            preparedStatement.setString(1, event.getLogin());
            preparedStatement.setString(2, new String(new SlowHasher().calculateSlowHash(new SHA256(), event.getPassword(), salt), StandardCharsets.UTF_8));
            preparedStatement.setBytes(3, salt);
            preparedStatement.setString(4, event.getEmail());
            preparedStatement.setString(5, event.getRegion());
            preparedStatement.setString(6, event.getFirst_name());
            preparedStatement.setString(7, event.getLast_name());
            preparedStatement.setDate(8, event.getDate());
            preparedStatement.setInt(9, event.getYear_st());
            preparedStatement.setString(10, event.getGender());
            preparedStatement.setString(11, event.getCar_mark());
            create = preparedStatement.executeUpdate();
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
        return create;
    }

    @Override
    public Integer deleteUser(String login, String password) {
        Integer delete = -1;
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM users WHERE login = ?");
            preparedStatement.setString(1, login);
            PreparedStatement statement = connection.prepareStatement("SELECT password, salt FROM users WHERE login = ?");
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String pwd = resultSet.getString(1);
                String salt = resultSet.getString(2);
                if (new String(new SlowHasher().calculateSlowHash(new SHA256(), password, salt.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8).equals(pwd)) {
                    delete = preparedStatement.executeUpdate();
                }
            }

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
        return delete;
    }

    @Override
    public Integer updateUser(User event) {
        Integer update = -1;
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("UPDATE users SET region = ?, email = ?, password = ?, year_st = ?, car_mark = ? where id = ? ");
            preparedStatement.setString(1, event.getRegion());
            preparedStatement.setString(2, event.getEmail());
            byte[] salt = new byte[16];
            new SecureRandom().nextBytes(salt);
            preparedStatement.setString(3, new String(new SlowHasher().calculateSlowHash(new SHA256(), event.getPassword(), salt), StandardCharsets.UTF_8));
            preparedStatement.setInt(4, event.getYear_st());
            preparedStatement.setString(5, event.getCar_mark());
            preparedStatement.setInt(6, event.getId());
            update = preparedStatement.executeUpdate();
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
        return update;
    }

    @Override
    public List<User> showAll() {
        ArrayList<User> users = new ArrayList<>();
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setSalt(resultSet.getBytes("salt"));
                user.setRegion(resultSet.getString("region"));
                user.setEmail(resultSet.getString("email"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setLast_name(resultSet.getString("last_name"));
                user.setDate(resultSet.getDate("date"));
                user.setGender(resultSet.getString("gender"));
                user.setCar_mark(resultSet.getString("car_mark"));
                user.setYear_st(resultSet.getInt("year"));
                users.add(user);
            }
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
        return users;
    }

    @Override
    public User getUser(String login) {
        User user = null;
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE login = ?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setSalt(resultSet.getBytes("salt"));
                user.setRegion(resultSet.getString("region"));
                user.setEmail(resultSet.getString("email"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setLast_name(resultSet.getString("last_name"));
                user.setDate(resultSet.getDate("date"));
                user.setGender(resultSet.getString("gender"));
                user.setCar_mark(resultSet.getString("car_mark"));
                user.setYear_st(resultSet.getInt("year_st"));
            }

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
        return user;
    }
}
