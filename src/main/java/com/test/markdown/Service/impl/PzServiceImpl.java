package com.test.markdown.Service.impl;

import com.test.markdown.Mapper.PzMapper;
import com.test.markdown.POJO.Article;
import com.test.markdown.Service.PzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PzServiceImpl implements PzService {
    @Autowired
    private  PzMapper pzMapper;
    @Override
    public List<Article> list(Integer start,Integer size) {
        return pzMapper.list(start,size);
    }

    @Override
    public Integer count() {
        return pzMapper.count();
    }

    @Override
    public Article getById(Integer id) {
        return pzMapper.getById(id);
    }

    @Override
    public void insert(Article pz) {
        pzMapper.insert(pz);
    }

    @Override
    public void updateById(Article pz) {
        pzMapper.updateById(pz);
    }

    @Override
    public void delete(List<Integer> idList) {
        pzMapper.delete(idList);
    }
}

