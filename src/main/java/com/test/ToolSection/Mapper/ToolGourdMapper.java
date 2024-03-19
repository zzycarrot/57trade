package com.test.ToolSection.Mapper;

import com.test.ToolSection.POJO.Tool;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ToolGourdMapper {


    public List<Tool> list() ;

    @Delete("delete from toolGourd where id = #{id}")
    Integer delete(Integer id);

    @Insert("INSERT into toolGourd (tradeplatform.toolGourd.name, tradeplatform.toolGourd.price, tradeplatform.toolGourd.qq, tradeplatform.toolGourd.image, tradeplatform.toolGourd.create_time, tradeplatform.toolGourd.update_time, tradeplatform.toolGourd.weight, tradeplatform.toolGourd.view) " +
            " values(#{name},#{price},#{qq},#{image},#{createTime},#{updateTime},#{weight},#{view})")
    void insert(Tool tool);

    List<Tool> selectpage(Integer start, Integer pagesize, String name, Integer ishot, Integer beginPrice, Integer endPrice);

    @Update("update toolGourd set tradeplatform.toolGourd.name = #{name},tradeplatform.toolGourd.price = #{price},tradeplatform.toolGourd.qq = #{qq},tradeplatform.toolGourd.image = #{image},tradeplatform.toolGourd.update_time = #{updateTime},tradeplatform.toolGourd.weight = #{weight},tradeplatform.toolGourd.view = #{view} where id = #{id}")
    Integer update(Tool tool);

    @Select("select * from toolGourd where id = #{id}")
    Tool select(Integer id);
}
