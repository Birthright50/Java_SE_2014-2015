package ru.kpfu.itis.peter_kozlovsky.singleton;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.ServletContext;

/**
 * Created by Birthright on 18.10.2015.
 */
public class ConfigSingleton {
    private static Configuration configuration;
    private static final String encoding = "UTF-8";

    public static Configuration getConfiguration(ServletContext servletContext) {
        if (configuration == null) {
            configuration = new Configuration(Configuration.VERSION_2_3_23);
            configuration.setServletContextForTemplateLoading(servletContext, "/WEB-INF/templates");
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
            configuration.setDefaultEncoding(encoding);
            configuration.setURLEscapingCharset(encoding);
            configuration.setOutputEncoding(encoding);
        }
        return configuration;
    }
}
