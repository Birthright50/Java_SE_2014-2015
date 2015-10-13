import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Birthright on 13.10.2015.
 */
@WebServlet(name = "CustomsCalculatorServlet")
public class CustomsCalculatorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cm = request.getParameter("cm");
        String year = request.getParameter("year");
        String price = request.getParameter("autoprice");
        HashMap<String, Double> root = null;
        if (year != null && (cm != null && !cm.equals("no"))) {
            root = new HashMap<>();
            Double sum = CustomsCalculatorHelper.getInfo(cm, year, price);
            root.put("sum", sum);
        }
        try {
            ConfigSingleton.getConfiguration(getServletContext()).getTemplate("calc_hp.ftl").process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
