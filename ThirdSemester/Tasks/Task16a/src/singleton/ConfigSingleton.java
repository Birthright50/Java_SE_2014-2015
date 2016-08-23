package singleton;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.ServletContext;

public class ConfigSingleton {
    private static Configuration configuration;

    public static Configuration getConfiguration(ServletContext servletContext) {
        if (configuration == null) {
            configuration = new Configuration(Configuration.VERSION_2_3_23);
            configuration.setServletContextForTemplateLoading(servletContext, "/WEB-INF/templates");
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        }
        return configuration;
    }
}
