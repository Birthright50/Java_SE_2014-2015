package ru.kpfu.itis.peter_kozlovsky.db.repository;

import ru.kpfu.itis.peter_kozlovsky.db.model.Template;

import java.util.List;

/**
 * Created by Birthright on 19.10.2015.
 */
public interface TemplateRepository {
    Integer createNews(Template event);

    Integer deleteNews(String login, Integer id);

    Integer updateNews(Template event);

    List<Template> showAll();

    Template getTemplate(Integer id);

    List<Template> showAllForPage(int page, byte type);
}
