package com.test.ToolSection.Service.Impl;

import com.test.ToolSection.Mapper.ToolCharacterMapper;
import com.test.ToolSection.POJO.PageBean;
import com.test.ToolSection.POJO.Tool;
import com.test.ToolSection.Service.ToolCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class ToolCharacterServiceImpl implements ToolCharacterService {
    @Autowired
    private ToolCharacterMapper toolCharactorMapper;
    @Override
    public List<Tool> list() {

        return toolCharactorMapper.list();
    }

    @Override
    public Integer delete(Integer id) {
        return toolCharactorMapper.delete(id);
    }

    @Override
    public Integer insert(Tool tool) {
        tool.setCreateTime(LocalDateTime.now());
        tool.setUpdateTime(LocalDateTime.now());
        if(tool.getWeight()==null)tool.setWeight(3);
        if(tool.getView()==null)tool.setView(0);
        toolCharactorMapper.insert(tool);
        return 1;
    }

    @Override
    public PageBean selectpage(Integer start, Integer pagesize, String name, Integer ishot, Integer latest,Integer cost, Integer beginPrice, Integer endPrice) {
        Integer total;
        List<Tool> list= toolCharactorMapper.selectpage(start,pagesize,name,ishot,latest,cost,beginPrice,endPrice);

        total = toolCharactorMapper.count();
        PageBean pageBean = new PageBean(total,list);
        return pageBean;
    }

    @Override
    public Integer update(Tool tool) {
        tool.setUpdateTime(LocalDateTime.now());
        if(tool.getWeight()==null)tool.setWeight(3);
        if(tool.getView()==null)tool.setView(0);
        return toolCharactorMapper.update(tool);
    }

    @Override
    public Tool select(Integer id) {
        return toolCharactorMapper.select(id);
    }
}
