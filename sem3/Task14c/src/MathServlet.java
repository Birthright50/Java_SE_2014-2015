import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Birthright on 10.10.2015.
 */
@WebServlet(name = "MathServlet")
public class MathServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String path = request.getPathInfo();
        String[] array = path.split("/");
        if (array.length == 3) {
            try {
                Integer number1 = Integer.parseInt(array[1]);
                Integer number2 = Integer.parseInt(array[2]);
                Configuration configuration = ConfigSingleton.getConfiguration(getServletContext());
                Template template = configuration.getTemplate("math.ftl");
                HashMap<String, String> root = new HashMap<>(1);
                if (request.getRequestURL().toString().contains("add")) {
                    root.put("math", number1 + " + " + number2 + " = " + (number1 + number2));
                } else {
                    root.put("math", number1 + " * " + number2 + " = " + (number1 * number2));
                }
                template.process(root, response.getWriter());
            } catch (NumberFormatException | TemplateException e) {
                e.printStackTrace();
            }

        }
    }
}
