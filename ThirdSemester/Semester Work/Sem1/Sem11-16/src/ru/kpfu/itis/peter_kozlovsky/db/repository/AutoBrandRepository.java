package ru.kpfu.itis.peter_kozlovsky.db.repository;

import ru.kpfu.itis.peter_kozlovsky.db.model.AutoBrand;
import ru.kpfu.itis.peter_kozlovsky.singleton.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Birthright on 12.11.2015.
 */
public class AutoBrandRepository {
    public ArrayList<AutoBrand> giveAll(){
        ArrayList<AutoBrand> autoBrands = new ArrayList<>();
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM auto_brands ORDER BY name");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                AutoBrand autoBrand = new AutoBrand();
                autoBrand.setName(resultSet.getString("name"));
                autoBrand.setUrl(resultSet.getString("url"));
                autoBrands.add(autoBrand);
            }
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
        return autoBrands;
    }
}
