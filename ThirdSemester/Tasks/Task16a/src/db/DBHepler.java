package db;

import singleton.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Birthright on 17.10.2015.
 */
public class DBHepler {
    private static ArrayList<ArrayList<String>> arrayList;

    public static ArrayList<ArrayList<String>> getArray(String query) {
        arrayList = new ArrayList<>();
        Connection connection = ConnectionSingleton.getStatement();
        try {
            PreparedStatement preparedStatement;
            if (connection != null) {
                if (query.equals("first_query")) {
                    preparedStatement = connection.prepareStatement("SELECT c1.name, c2.name FROM students c1, classes c2 " +
                            "where exists(select * from attendance c3 where c3.class_id = c2.id AND c3.student_id = c1.id" +
                            " AND c3.year BETWEEN ? AND ?)");
                    preparedStatement.setInt(1, 1992);
                    preparedStatement.setInt(2, 1998);
                } else {
                    preparedStatement = connection.prepareStatement("SELECT c1.name, c2.year FROM students c1, attendance c2 where exists (select * from teachers c3 where c2.student_id=c1.id AND c2.teacher_id=c3.id AND c3.name = ?);");
                    preparedStatement.setString(1, "Horace Slughorn");
                }
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String student = resultSet.getString(1);
                    String subject = resultSet.getString(2);
                    ArrayList<String> list = new ArrayList<>(2);
                    list.add(student);
                    list.add(subject);
                    arrayList.add(list);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }
}
