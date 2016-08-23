package ru.kpfu.itis.peter_kozlovsky.db.repository;

import ru.kpfu.itis.peter_kozlovsky.db.model.Ad;
import ru.kpfu.itis.peter_kozlovsky.singleton.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Birthright on 14.11.2015.
 */
public class AdRepository {
    public List<Ad> showAll() {
        ArrayList<Ad> ads = new ArrayList<>();
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM ads");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ru.kpfu.itis.peter_kozlovsky.db.model.Ad ad = new ru.kpfu.itis.peter_kozlovsky.db.model.Ad();
                ad.setId_user(resultSet.getInt("id_user"));
                ad.setId(resultSet.getInt("id"));
                ad.setName(resultSet.getString("name"));
                ad.setPrice(resultSet.getInt("price"));
                ad.setProbeg(resultSet.getInt("probeg"));
                ad.setText(resultSet.getString("text"));
                ad.setYear(resultSet.getInt("year"));
                ad.setUrl_image_1(resultSet.getString("url_image_1"));
                ad.setUrl_image_2(resultSet.getString("url_image_2"));
                ad.setUrl_image_3(resultSet.getString("url_image_3"));
                ad.setUrl_image_4(resultSet.getString("url_image_4"));
                ad.setUrl_image_5(resultSet.getString("url_image_5"));
                ad.setCity(resultSet.getString("city"));
                ads.add(ad);
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
        return ads;
    }

    public Integer createAd(Ad event) {
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        Integer create = -1;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO ads (name, id_user, text, url_image_1,url_image_2,url_image_3,url_image_4,url_image_5, price,probeg ,year, city)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, event.getName());
            preparedStatement.setInt(2, event.getId_user());
            preparedStatement.setString(3, event.getText());
            preparedStatement.setString(4, event.getUrl_image_1());
            preparedStatement.setString(5, event.getUrl_image_2());
            preparedStatement.setString(6, event.getUrl_image_3());
            preparedStatement.setString(7, event.getUrl_image_4());
            preparedStatement.setString(8, event.getUrl_image_5());
            preparedStatement.setInt(9, event.getPrice());
            preparedStatement.setInt(10, event.getProbeg());
            preparedStatement.setInt(11, event.getYear());
            preparedStatement.setString(12, event.getCity());
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

    public Ad getAd(Integer id) {
        ru.kpfu.itis.peter_kozlovsky.db.model.Ad ad = null;
        Connection connection = ConnectionSingleton.getStatement();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ads WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                ad = new ru.kpfu.itis.peter_kozlovsky.db.model.Ad();
                ad.setId(id);
                ad.setId_user(resultSet.getInt("id_user"));
                ad.setName(resultSet.getString("name"));
                ad.setPrice(resultSet.getInt("price"));
                ad.setProbeg(resultSet.getInt("probeg"));
                ad.setText(resultSet.getString("text"));
                ad.setYear(resultSet.getInt("year"));
                ad.setUrl_image_1(resultSet.getString("url_image_1"));
                ad.setUrl_image_2(resultSet.getString("url_image_2"));
                ad.setUrl_image_3(resultSet.getString("url_image_3"));
                ad.setUrl_image_4(resultSet.getString("url_image_4"));
                ad.setUrl_image_5(resultSet.getString("url_image_5"));
                ad.setCity(resultSet.getString("city"));
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
        return ad;
    }

}
