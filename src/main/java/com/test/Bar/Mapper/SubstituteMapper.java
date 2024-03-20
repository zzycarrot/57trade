package com.test.Bar.Mapper;

import com.test.Bar.POJO.Tool;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SubstituteMapper {


    public List<Tool> list() ;

    @Delete("delete from substitute where id = #{id}")
    Integer delete(Integer id);

    @Insert("INSERT into substitute (tradeplatform.substitute.name, reward,tradeplatform.substitute.price, tradeplatform.substitute.qq,info,time, tradeplatform.substitute.create_time, tradeplatform.substitute.update_time, tradeplatform.substitute.weight, tradeplatform.substitute.view) " +
            " values(#{name},#{reward},#{price},#{qq},#{info},#{time},#{createTime},#{updateTime},#{weight},#{view})")
    void insert(Tool tool);

    List<Tool> selectpage(Integer start, Integer pagesize, String name, Integer ishot, Integer cost , Integer beginPrice, Integer endPrice);

    @Update("update substitute set tradeplatform.substitute.name = #{name},reward = #{reward},tradeplatform.substitute.price = #{price},tradeplatform.substitute.qq = #{qq},info=#{info},time=#{time},tradeplatform.substitute.update_time = #{updateTime},tradeplatform.substitute.weight = #{weight},tradeplatform.substitute.view = #{view} where id = #{id}")
    Integer update(Tool tool);

    @Select("select * from substitute where id = #{id}")
    Tool select(Integer id);
}
