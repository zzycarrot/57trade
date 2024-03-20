package com.test.Bar.Service.Impl;

import com.test.Bar.Mapper.NeedsMapper;
import com.test.Bar.POJO.PageBean;
import com.test.Bar.POJO.Tool;
import com.test.Bar.Service.NeedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class NeedsServiceImpl implements NeedsService {
    @Autowired
    private NeedsMapper needsMapper;
    @Override
    public List<Tool> list() {

        return needsMapper.list();
    }

    @Override
    public Integer delete(Integer id) {
        return needsMapper.delete(id);
    }

    @Override
    public Integer insert(Tool tool) {
        tool.setCreateTime(LocalDateTime.now());
        tool.setUpdateTime(LocalDateTime.now());
        if(tool.getWeight()==null)tool.setWeight(3);
        if(tool.getView()==null)tool.setView(0);
        needsMapper.insert(tool);
        return 1;
    }

    @Override
    public PageBean selectpage(Integer start, Integer pagesize, String name, Integer ishot, Integer latest, Integer cost, Integer beginPrice, Integer endPrice) {
        Integer total;
        List<Tool> list= needsMapper.selectpage(start,pagesize,name,ishot,cost,latest,beginPrice,endPrice);

        total = needsMapper.count();
        PageBean pageBean = new PageBean(total,list);
        return pageBean;
    }

    @Override
    public Integer update(Tool tool) {
        tool.setUpdateTime(LocalDateTime.now());
        if(tool.getWeight()==null)tool.setWeight(3);
        if(tool.getView()==null)tool.setView(0);
        return needsMapper.update(tool);
    }

    @Override
    public Tool select(Integer id) {
        return needsMapper.select(id);
    }
}
