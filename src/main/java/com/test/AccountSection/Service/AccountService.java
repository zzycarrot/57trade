package com.test.AccountSection.Service;

import com.test.AccountSection.POJO.PageBean;
import com.test.AccountSection.POJO.Tool;

import java.util.List;


public interface AccountService {
    List<Tool> list();

    Integer delete(Integer id);

    Integer insert(Tool tool);

    PageBean selectpage(Integer start, Integer pagesize, String name, Integer ishot,Integer latest,Integer cost, Integer beginPrice, Integer endPrice);

    Integer update(Tool tool);

    Tool select(Integer id);
}
