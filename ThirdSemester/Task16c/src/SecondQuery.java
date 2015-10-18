import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;

/**
 * Created by Birthright on 19.10.2015.
 */
public class SecondQuery {
    public static void main(String[] args) {
        Connection connection = ConnectionSingleton.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT c1.name, c2.year FROM students c1, attendance c2 where exists (select * from teachers c3 where c2.student_id=c1.id AND c2.teacher_id=c3.id AND c3.name = ?);");
            preparedStatement.setString(1, "Horace Slughorn");
            ResultSet resultSet = preparedStatement.executeQuery();
            StringBuilder stringBuilder = new StringBuilder();
            Formatter formatter = new Formatter(stringBuilder);
            formatter.format("%-20s%-25s%n", "Student name", "Year");
            stringBuilder.append("-----------------------------------------------------\n");
            while(resultSet.next()){
                formatter.format("%-20s%-25s%n", resultSet.getString(1), resultSet.getInt(2));
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
