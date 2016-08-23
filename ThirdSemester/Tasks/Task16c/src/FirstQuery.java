import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;

/**
 * Created by Birthright on 18.10.2015.
 */
public class FirstQuery {
    public static void main(String[] args) {
        Connection connection = ConnectionSingleton.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT c1.name, c2.name FROM students c1, classes c2 " +
                    "where exists(select * from attendance c3 where c3.class_id = c2.id AND c3.student_id = c1.id" +
                    " AND c3.year BETWEEN ? AND ?)");
            preparedStatement.setInt(1, 1992);
            preparedStatement.setInt(2, 1998);
            ResultSet resultSet = preparedStatement.executeQuery();
            StringBuilder stringBuilder = new StringBuilder();
            Formatter formatter = new Formatter(stringBuilder);
            formatter.format("%-20s%-25s%n", "Student name", "Class name");
            stringBuilder.append("-----------------------------------------------------\n");
            while(resultSet.next()){
                formatter.format("%-20s%-25s%n", resultSet.getString(1), resultSet.getString(2));
            }
            System.out.println(stringBuilder);
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
