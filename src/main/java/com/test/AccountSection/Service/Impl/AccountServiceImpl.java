package com.test.AccountSection.Service.Impl;

import com.test.AccountSection.Mapper.AccountMapper;
import com.test.AccountSection.POJO.PageBean;
import com.test.AccountSection.POJO.Tool;
import com.test.AccountSection.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public List<Tool> list() {

        return accountMapper.list();
    }

    @Override
    public Integer delete(Integer id) {
        return accountMapper.delete(id);
    }

    @Override
    public Integer insert(Tool tool) {
        tool.setCreateTime(LocalDateTime.now());
        tool.setUpdateTime(LocalDateTime.now());
        if(tool.getWeight()==null)tool.setWeight(3);
        if(tool.getView()==null)tool.setView(0);
        accountMapper.insert(tool);
        return 1;
    }

    @Override
    public PageBean selectpage(Integer start, Integer pagesize, String name, Integer ishot, Integer beginPrice, Integer endPrice) {
        Integer total;
        List<Tool> list= accountMapper.selectpage(start,pagesize,name,ishot,beginPrice,endPrice);
        total = list.size();
        PageBean pageBean = new PageBean(total,list);
        return pageBean;
    }

    @Override
    public Integer update(Tool tool) {
        tool.setUpdateTime(LocalDateTime.now());
        if(tool.getWeight()==null)tool.setWeight(3);
        if(tool.getView()==null)tool.setView(0);
        return accountMapper.update(tool);
    }

    @Override
    public Tool select(Integer id) {
        return accountMapper.select(id);
    }
}
