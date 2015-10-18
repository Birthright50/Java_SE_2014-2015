package servlets;

import db.DBHelper;
import db.model.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import singleton.ConfigSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 * Created by Birthright on 18.10.2015.
 */
@WebServlet(name = "servlets.RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String username = request.getParameter("login");
        String email = request.getParameter("email");
        String region = request.getParameter("input1");
        String car_mark = request.getParameter("input2");
        String first_name = request.getParameter("name[first]");
        String last_name = request.getParameter("name[last]");
        String date = request.getParameter("date");
        String year_st = request.getParameter("number");

        Boolean checkUser = DBHelper.checkRegistration(username);
        if (checkUser) {
            System.out.println(checkUser);
            httpSession.setAttribute("error_msg", "Username already exists");
            httpSession.setAttribute("name", username);
            httpSession.setAttribute("email", email);
            httpSession.setAttribute("region", region);
            httpSession.setAttribute("car_mark", car_mark);
            httpSession.setAttribute("first_name", first_name);
            httpSession.setAttribute("last_name", last_name);
            httpSession.setAttribute("date", date);
            httpSession.setAttribute("year_st", year_st);
            response.sendRedirect("/registration");
            return;
        }
        String password = request.getParameter("password");
        String gender = request.getParameter("select");
        System.out.println(gender);
        try {
            User user = new User(username, password, email, region, first_name, last_name, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime()), Integer.parseInt(year_st), gender, car_mark);
            if (DBHelper.userRepository.createUser(user)) {
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
        response.setContentType("text/html");
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
            response.sendRedirect("/news");
        } else {

            Configuration configuration = ConfigSingleton.getConfiguration(getServletContext());
            Template template = configuration.getTemplate("registration.ftl");
            String error = (String) httpSession.getAttribute("error_msg");
            String name = (String) httpSession.getAttribute("login");
            String email = (String) httpSession.getAttribute("email");
            String region = (String) httpSession.getAttribute("region");
            String car_mark = (String) httpSession.getAttribute("car_mark");
            String first_name = (String) httpSession.getAttribute("first_name");
            String last_name = (String) httpSession.getAttribute("last_name");
            String date = (String) httpSession.getAttribute("date");
            String year_st = (String) httpSession.getAttribute("year_st");
            HashMap<String, String> root = new HashMap<>();
            root.put("error", error);
            root.put("name", name);
            root.put("email", email);
            root.put("region", region);
            root.put("car_mark", car_mark);
            root.put("date", date);
            root.put("year_st", year_st);
            root.put("first_name", first_name);
            root.put("last_name", last_name);
            try {
                template.process(root, response.getWriter());
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        }
    }
}
