package ru.kpfu.itis.peter_kozlovsky.servlets;


import ru.kpfu.itis.peter_kozlovsky.db.DBHelper;
import ru.kpfu.itis.peter_kozlovsky.db.model.User;
import freemarker.template.TemplateException;
import ru.kpfu.itis.peter_kozlovsky.singleton.ConfigSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.lang.String;

/**
 * Created by Birthright on 20.10.2015.
 */
@WebServlet(name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        Cookie[] cookies = request.getCookies();
        Cookie username = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("login")) {
                    username = cookie;
                    break;
                }
            }
        }
        HttpSession httpSession = request.getSession();
        String login = (String) httpSession.getAttribute("login");
        User user = new User();
        user.setLogin(login != null ? login : username.getValue());
        user.setCar_mark(request.getParameter("car_mark"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("pwd"));
        user.setRegion(request.getParameter("region"));
        user.setYear_st(Integer.valueOf(request.getParameter("number")));
        int result = DBHelper.userRepository.updateUser(user);
        if (result > 0) {
            response.sendRedirect("/profile");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        Cookie[] cookies = request.getCookies();
        Cookie username = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("login")) {
                    username = cookie;
                    break;
                }
            }
        }
        HttpSession httpSession = request.getSession();
        String login = (String) httpSession.getAttribute("login");
        if (login != null || username != null) {
            login = login != null ? login : username.getValue();
            User user = DBHelper.userRepository.getUser(login);
            HashMap<String, String> root = new HashMap<>();
            root.put("login", login);
            root.put("date", user.getDate().toString());
            root.put("first_last_name", user.getFirst_name() + " " + user.getLast_name());
            root.put("gender", user.getGender());
            root.put("region", user.getRegion());
            root.put("car_mark", user.getCar_mark());
            root.put("email", user.getEmail());
            root.put("year", user.getYear_st() + "");
            try {
                ConfigSingleton.getConfiguration(getServletContext()).getTemplate("profile.ftl").process(root, response.getWriter());
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("/login");
        }
    }
}
