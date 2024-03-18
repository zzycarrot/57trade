package com.test.ToolSection.Mapper;

import com.test.ToolSection.POJO.Tool;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ToolCharacterMapper {


    public List<Tool> list() ;

    @Delete("delete from toolcharacter where id = #{id}")
    Integer delete(Integer id);

    @Insert("INSERT into toolcharacter (tradeplatform.toolcharacter.name, tradeplatform.toolcharacter.price, tradeplatform.toolcharacter.qq, tradeplatform.toolcharacter.image, tradeplatform.toolcharacter.create_time, tradeplatform.toolcharacter.update_time, tradeplatform.toolcharacter.weight, tradeplatform.toolcharacter.view) " +
            " values(#{name},#{price},#{qq},#{image},#{createTime},#{updateTime},#{weight},#{view})")
    void insert(Tool tool);

    List<Tool> selectpage(Integer start, Integer pagesize, String name, Integer ishot, Integer beginPrice, Integer endPrice);

}
