package ru.kpfu.itis.peter_kozlovsky.servlets;

import ru.kpfu.itis.peter_kozlovsky.db.DBHelper;
import ru.kpfu.itis.peter_kozlovsky.db.model.User;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Birthright on 18.10.2015.
 */
@WebServlet(name = "ru.kpfu.itis.peter_kozlovsky.servlets.RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession httpSession = request.getSession();
        String username = request.getParameter("input");
        String email = request.getParameter("email");
        String region = request.getParameter("region");
        String car_mark = request.getParameter("car_mark");
        String first_name = request.getParameter("name[first]");
        String last_name = request.getParameter("name[last]");
        String date = request.getParameter("date");
        String year_st = request.getParameter("number");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        try {
            User user = new User(username, password, email, region, first_name, last_name, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime()), Integer.parseInt(year_st), gender, car_mark);
            if (DBHelper.userRepository.createUser(user) > 0) {
                httpSession.setAttribute("login", username);
                response.sendRedirect("/news");
            } else {
                System.out.println("Something wrong");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String input = request.getParameter("input");
        JSONObject jsonObject = new JSONObject();
        System.out.println(input);
        System.out.println(DBHelper.checkRegistration(input));
        jsonObject.put("results", DBHelper.checkRegistration(input));
        response.getWriter().print(jsonObject.toString());
        if (input == null) {
            response.sendRedirect("/news");
        }

    }
}
