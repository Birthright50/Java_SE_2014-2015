package ru.kpfu.itis.peter_kozlovsky.servlets;

import ru.kpfu.itis.peter_kozlovsky.db.DBHelper;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Birthright on 18.10.2015.
 */
@WebServlet(name = "ru.kpfu.itis.peter_kozlovsky.servlets.LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession httpSession = request.getSession();
        String login = request.getParameter("input");
        String checkbox = request.getParameter("checkbox[]");
        if (checkbox != null) {
            Cookie loginCookie = new Cookie("login", login);
            loginCookie.setMaxAge(30 * 60);
            response.addCookie(loginCookie);
        }
        httpSession.setAttribute("login", login);
        response.sendRedirect("/news");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String input = request.getParameter("input");
        String password = request.getParameter("password");
        String result = DBHelper.checkUser(input, password);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("results", result);
        response.getWriter().print(jsonObject.toString());
        if (input == null || password == null) {
            response.sendRedirect("/news");
        }
    }
}
