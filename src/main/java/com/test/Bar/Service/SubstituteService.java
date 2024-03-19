package com.test.Bar.Service;

import com.test.Bar.POJO.PageBean;
import com.test.Bar.POJO.Tool;

import java.util.List;


public interface SubstituteService {
    List<Tool> list();

    Integer delete(Integer id);

    Integer insert(Tool tool);

    PageBean selectpage(Integer start, Integer pagesize, String name, Integer ishot, Integer latest, Integer cost, Integer beginPrice, Integer endPrice);

    Integer update(Tool tool);

    Tool select(Integer id);
}
