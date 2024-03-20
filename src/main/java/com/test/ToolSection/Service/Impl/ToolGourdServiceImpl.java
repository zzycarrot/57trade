package com.test.ToolSection.Service.Impl;

import com.test.ToolSection.Mapper.ToolGourdMapper;
import com.test.ToolSection.POJO.PageBean;
import com.test.ToolSection.POJO.Tool;
import com.test.ToolSection.Service.ToolGourdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ToolGourdServiceImpl implements ToolGourdService {
    @Autowired
    private ToolGourdMapper toolGourdMapper;
    @Override
    public List<Tool> list() {

        return toolGourdMapper.list();
    }

    @Override
    public Integer delete(Integer id) {
        return toolGourdMapper.delete(id);
    }

    @Override
    public Integer insert(Tool tool) {
        tool.setCreateTime(LocalDateTime.now());
        tool.setUpdateTime(LocalDateTime.now());
        if(tool.getWeight()==null)tool.setWeight(3);
        if(tool.getView()==null)tool.setView(0);
        toolGourdMapper.insert(tool);
        return 1;
    }

    @Override
    public PageBean selectpage(Integer start, Integer pagesize, String name, Integer ishot, Integer beginPrice, Integer endPrice) {
        Integer total;
        List<Tool> list= toolGourdMapper.selectpage(start,pagesize,name,ishot,beginPrice,endPrice);
        total = toolGourdMapper.count();
        PageBean pageBean = new PageBean(total,list);
        return pageBean;
    }

    @Override
    public Integer update(Tool tool) {
        tool.setUpdateTime(LocalDateTime.now());
        if(tool.getWeight()==null)tool.setWeight(3);
        if(tool.getView()==null)tool.setView(0);
        return toolGourdMapper.update(tool);
    }

    @Override
    public Tool select(Integer id) {
        return toolGourdMapper.select(id);
    }
}
