package db.repository;

import db.model.News;

import java.util.List;

/**
 * Created by Birthright on 19.10.2015.
 */
public interface NewsRepository {
    Integer createNews(News event);

    Integer deleteNews(String login, Integer id);

    Integer updateNews(News event);

    List<News> showAll();

    News getNews(Integer id);
}
