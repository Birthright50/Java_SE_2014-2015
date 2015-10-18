package servlets;

import db.DBHepler;
import freemarker.template.TemplateException;
import singleton.ConfigSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Birthright on 17.10.2015.
 */
@WebServlet(name = "servlets.SecondQueryServlet")
public class SecondQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, ArrayList<ArrayList<String>>> root = new HashMap<>(1);
        root.put("query", DBHepler.getArray("second_query"));
        try {
            ConfigSingleton.getConfiguration(getServletContext()).getTemplate("second.ftl").process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
