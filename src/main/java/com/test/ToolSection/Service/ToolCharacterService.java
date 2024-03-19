package com.test.ToolSection.Service;

import com.test.ToolSection.POJO.PageBean;
import com.test.ToolSection.POJO.Tool;

import java.util.List;


public interface ToolCharacterService {
    List<Tool> list();

    Integer delete(Integer id);

    Integer insert(Tool tool);

    PageBean selectpage(Integer start, Integer pagesize, String name, Integer ishot, Integer latest, Integer cost, Integer beginPrice, Integer endPrice);

    Integer update(Tool tool);

    Tool select(Integer id);
}
