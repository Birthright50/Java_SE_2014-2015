package ru.kpfu.itis.peter_kozlovsky.servlets;

import freemarker.template.TemplateException;
import ru.kpfu.itis.peter_kozlovsky.helpers.HPCalculatorInfo;
import org.json.simple.JSONObject;
import ru.kpfu.itis.peter_kozlovsky.singleton.ConfigSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Birthright on 13.10.2015.
 */
@WebServlet(name = "HPCalculatorServlet")
public class HPCalculatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        JSONObject jsonObject = new JSONObject();
        String region = request.getParameter("region");
        String horse_power = request.getParameter("hp");
        String period = request.getParameter("period");
        Double hp = HPCalculatorInfo.getRate(region, horse_power, period);
        jsonObject.put("price", hp + " RUB");
        response.getWriter().print(jsonObject.toString());
    }

    @Override
    public void init() throws ServletException {
        HPCalculatorInfo.createInfo();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HashMap<String, Object> root = new HashMap<>();
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
            root.put("login", login != null ? login : username.getValue());
        }
        try {
            ConfigSingleton.getConfiguration(getServletContext()).getTemplate("calc_hp.ftl").process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
