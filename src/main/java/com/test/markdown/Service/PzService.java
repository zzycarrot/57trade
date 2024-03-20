package com.test.markdown.Service;
import com.test.markdown.POJO.Article;

import java.util.List;


public interface PzService {

    List<Article> list(Integer start ,Integer size);

    Integer count();

    Article getById(Integer id);

    void insert(Article article);

    void updateById(Article article);

    void delete(List<Integer> idList);
}

