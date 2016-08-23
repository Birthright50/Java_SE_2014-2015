package ru.kpfu.itis.peter_kozlovsky.db.repository;

import ru.kpfu.itis.peter_kozlovsky.db.model.AutoModel;
import ru.kpfu.itis.peter_kozlovsky.singleton.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Birthright on 12.11.2015.
 */
public class AutoModelRepository {
    public ArrayList<AutoModel> getByBrand(String auto_brand) {
        ArrayList<AutoModel> autoModels = new ArrayList<>();
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM auto_model where name_brand = ? ORDER BY name");
            preparedStatement.setString(1, auto_brand);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                AutoModel autoModel = new AutoModel();
                autoModel.setName(resultSet.getString("name"));
                autoModel.setUrl(resultSet.getString("url"));
                autoModel.setBody(resultSet.getString("body"));
                autoModel.setName_brand(resultSet.getString("name_brand"));
                autoModel.setYear(resultSet.getInt("year"));
                autoModel.setImage_url_1(resultSet.getString("image_url_1"));
                autoModel.setImage_url_2(resultSet.getString("image_url_2"));
                autoModel.setImage_url_3(resultSet.getString("image_url_3"));
                autoModel.setImage_url_4(resultSet.getString("image_url_4"));
                autoModel.setImage_url_5(resultSet.getString("image_url_5"));
                autoModel.setText(resultSet.getString("text"));
                autoModels.add(autoModel);
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
        return autoModels;
    }

    public AutoModel getModel(String auto_brand, String auto_model) {
        AutoModel autoModel = new AutoModel();
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM auto_model where name_brand = ? AND name = ? ORDER BY name");
            preparedStatement.setString(1, auto_brand);
            preparedStatement.setString(2, auto_model);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                autoModel.setName(resultSet.getString("name"));
                autoModel.setUrl(resultSet.getString("url"));
                autoModel.setBody(resultSet.getString("body"));
                autoModel.setName_brand(resultSet.getString("name_brand"));
                autoModel.setYear(resultSet.getInt("year"));
                autoModel.setImage_url_1(resultSet.getString("image_url_1"));
                autoModel.setImage_url_2(resultSet.getString("image_url_2"));
                autoModel.setImage_url_3(resultSet.getString("image_url_3"));
                autoModel.setImage_url_4(resultSet.getString("image_url_4"));
                autoModel.setImage_url_5(resultSet.getString("image_url_5"));
                autoModel.setText(resultSet.getString("text"));

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
        return autoModel;
    }
}
