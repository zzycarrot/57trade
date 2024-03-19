package com.test.ToolSection.Mapper;

import com.test.ToolSection.POJO.Tool;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ToolPetMapper {


    public List<Tool> list() ;

    @Delete("delete from toolPet where id = #{id}")
    Integer delete(Integer id);

    @Insert("INSERT into toolPet (tradeplatform.toolPet.name, tradeplatform.toolPet.price, tradeplatform.toolPet.qq, tradeplatform.toolPet.image, tradeplatform.toolPet.create_time, tradeplatform.toolPet.update_time, tradeplatform.toolPet.weight, tradeplatform.toolPet.view) " +
            " values(#{name},#{price},#{qq},#{image},#{createTime},#{updateTime},#{weight},#{view})")
    void insert(Tool tool);

    List<Tool> selectpage(Integer start, Integer pagesize, String name, Integer ishot, Integer beginPrice, Integer endPrice);

    @Update("update toolPet set tradeplatform.toolPet.name = #{name},tradeplatform.toolPet.price = #{price},tradeplatform.toolPet.qq = #{qq},tradeplatform.toolPet.image = #{image},tradeplatform.toolPet.update_time = #{updateTime},tradeplatform.toolPet.weight = #{weight},tradeplatform.toolPet.view = #{view} where id = #{id}")
    Integer update(Tool tool);
}
