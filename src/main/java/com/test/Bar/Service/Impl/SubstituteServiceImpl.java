package com.test.Bar.Service.Impl;

import com.test.Bar.Mapper.SubstituteMapper;
import com.test.Bar.POJO.PageBean;
import com.test.Bar.POJO.Tool;
import com.test.Bar.Service.SubstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class SubstituteServiceImpl implements SubstituteService {
    @Autowired
    private SubstituteMapper substituteMapper;
    @Override
    public List<Tool> list() {

        return substituteMapper.list();
    }

    @Override
    public Integer delete(Integer id) {
        return substituteMapper.delete(id);
    }

    @Override
    public Integer insert(Tool tool) {
        tool.setCreateTime(LocalDateTime.now());
        tool.setUpdateTime(LocalDateTime.now());
        if(tool.getWeight()==null)tool.setWeight(3);
        if(tool.getView()==null)tool.setView(0);
        substituteMapper.insert(tool);
        return 1;
    }

    @Override
    public PageBean selectpage(Integer start, Integer pagesize, String name, Integer ishot, Integer latest, Integer cost, Integer beginPrice, Integer endPrice) {
        Integer total;
        List<Tool> list= substituteMapper.selectpage(start,pagesize,name,ishot,cost,beginPrice,endPrice);
        if(ishot == 0){
            if (latest.equals(0))
                Collections.reverse(list);
        }
        total = substituteMapper.count();
        PageBean pageBean = new PageBean(total,list);
        return pageBean;
    }

    @Override
    public Integer update(Tool tool) {
        tool.setUpdateTime(LocalDateTime.now());
        if(tool.getWeight()==null)tool.setWeight(3);
        if(tool.getView()==null)tool.setView(0);
        return substituteMapper.update(tool);
    }

    @Override
    public Tool select(Integer id) {
        return substituteMapper.select(id);
    }
}
