/**
 * Created by Birthright on 31.10.2015.
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    Connection conn;

    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/MyBase",
                    "postgres",
                    "root"
            );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String q = request.getParameter("q");
        String s = request.getParameter("entity");
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "select name from " + s + " WHERE name LIKE ?"
            );
            ps.setString(1, "%" + q + "%");
            ResultSet rs = ps.executeQuery();
            JSONArray ja = new JSONArray();

            while (rs.next()) {
                ja.add(rs.getString("name"));
            }
            JSONObject jo = new JSONObject();
            jo.put("results", ja);
            response.getWriter().print(jo.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
