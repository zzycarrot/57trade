package com.test.markdown.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.markdown.Mapper.ArticleMapper;
import com.test.markdown.POJO.Article;
import com.test.markdown.Service.ArticleService;

import java.util.List;

@Service
public class ArticleServiceImpl  implements ArticleService {
    @Autowired
    private  ArticleMapper articleMapper;
    @Override
    public List<Article> list(Integer start,Integer size) {
        return articleMapper.list(start,size);
    }

    @Override
    public Integer count() {
        return articleMapper.count();
    }

    @Override
    public Article getById(Integer id) {
        return articleMapper.getById(id);
    }

    @Override
    public void insert(Article article) {
        articleMapper.insert(article);
    }

    @Override
    public void updateById(Article article) {
        articleMapper.updateById(article);
    }

    @Override
    public void delete(List<Integer> idList) {
        articleMapper.delete(idList);
    }
}

