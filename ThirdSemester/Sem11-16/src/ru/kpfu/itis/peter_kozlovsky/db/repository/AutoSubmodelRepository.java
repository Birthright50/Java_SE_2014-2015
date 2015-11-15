package ru.kpfu.itis.peter_kozlovsky.db.repository;

import ru.kpfu.itis.peter_kozlovsky.db.model.AutoSubmodel;
import ru.kpfu.itis.peter_kozlovsky.singleton.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Birthright on 12.11.2015.
 */
public class AutoSubmodelRepository {
    public ArrayList<AutoSubmodel> getSubmodelsByModel(String auto_brand, String auto_model){
        ArrayList<AutoSubmodel> autoSubmodels = new ArrayList<>();
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM auto_submodels where name_brand = ? AND name_model = ? ORDER BY name");
            preparedStatement.setString(1, auto_brand);
            preparedStatement.setString(2, auto_model);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               AutoSubmodel autoSubmodel = new AutoSubmodel();
                autoSubmodel.setName(resultSet.getString("name"));
                autoSubmodel.setName_brand(resultSet.getString("name_brand"));
                autoSubmodel.setAcceleration(resultSet.getDouble("acceleration"));
                autoSubmodel.setCapacity(resultSet.getInt("capacity"));
                autoSubmodel.setFlowrate(resultSet.getInt("flowrate"));
                autoSubmodel.setName_model(resultSet.getString("name_model"));
                autoSubmodel.setPower(resultSet.getInt("power"));
                autoSubmodel.setPrice(resultSet.getInt("price"));
                autoSubmodel.setSpeed(resultSet.getInt("speed"));
                autoSubmodels.add(autoSubmodel);
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
        return autoSubmodels;
    }
}
