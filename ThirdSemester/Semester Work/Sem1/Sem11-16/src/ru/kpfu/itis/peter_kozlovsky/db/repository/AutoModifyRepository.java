package ru.kpfu.itis.peter_kozlovsky.db.repository;

import ru.kpfu.itis.peter_kozlovsky.db.model.AutoModify;
import ru.kpfu.itis.peter_kozlovsky.singleton.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Birthright on 12.11.2015.
 */
public class AutoModifyRepository {
    public AutoModify getAuto(String name_brand, String name_model, String name_submodel) {
        AutoModify autoModify = new AutoModify();
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM auto_modify where name_brand = ? AND name_model = ? AND name_submodel = ?");
            preparedStatement.setString(1, name_brand);
            preparedStatement.setString(2, name_model);
            preparedStatement.setString(3, name_submodel);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                autoModify.setName(resultSet.getString("name"));
                autoModify.setName_model(resultSet.getString("name_model"));
                autoModify.setAcceleration(resultSet.getDouble("acceleration"));
                autoModify.setCapacity(resultSet.getInt("capacity"));
                autoModify.setClearence(resultSet.getInt("clearence"));
                autoModify.setDisk(resultSet.getString("disk"));
                autoModify.setDrive(resultSet.getString("drive"));
                autoModify.setEngine_type(resultSet.getString("engine_type"));
                autoModify.setFuel(resultSet.getString("fuel"));
                autoModify.setGearBox(resultSet.getString("gear_box"));
                autoModify.setName_brand(resultSet.getString("name_brand"));
                autoModify.setName_submodel(resultSet.getString("name_submodel"));
                autoModify.setPower(resultSet.getString("power"));
                autoModify.setSize(resultSet.getString("size"));
                autoModify.setTires(resultSet.getString("tires"));
                autoModify.setTorque(resultSet.getString("torque"));
                autoModify.setWeight(resultSet.getInt("weight"));
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
        return autoModify;
    }
}
