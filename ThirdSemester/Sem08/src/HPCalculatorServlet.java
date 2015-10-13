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
@WebServlet(name = "HPCalculatorServlet")
public class HPCalculatorServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
        HPCalculatorInfo.createInfo();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String region = request.getParameter("region");
        String horse_power = request.getParameter("hp");
        String period = request.getParameter("period");
        HashMap<String, Double> root = null;
        if ((region != null && !region.equals("no")) && horse_power != null && (period != null && !period.equals("0"))) {
            root = new HashMap<>();
            Double hp = HPCalculatorInfo.getRate(region, horse_power, period);
            root.put("sum", hp);
        }

        try {
            ConfigSingleton.getConfiguration(getServletContext()).getTemplate("calc_hp.ftl").process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
