package com.test.Bar.Mapper;

import com.test.Bar.POJO.Tool;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NeedsMapper {


    @Select("select count(*) from needs")
    Integer count();

    public List<Tool> list() ;

    @Delete("delete from needs where id = #{id}")
    Integer delete(Integer id);

    @Insert("INSERT into needs (tradeplatform.needs.name, tradeplatform.needs.price, tradeplatform.needs.qq,info,time, tradeplatform.needs.create_time, tradeplatform.needs.update_time, tradeplatform.needs.weight, tradeplatform.needs.view) " +
            " values(#{name},#{price},#{qq},#{info},#{time},#{createTime},#{updateTime},#{weight},#{view})")
    void insert(Tool tool);

    List<Tool> selectpage(Integer start, Integer pagesize, String name, Integer ishot, Integer cost ,Integer latest, Integer beginPrice, Integer endPrice);

    @Update("update needs set tradeplatform.needs.name = #{name},tradeplatform.needs.price = #{price},tradeplatform.needs.qq = #{qq},info=#{info},time=#{time},tradeplatform.needs.update_time = #{updateTime},tradeplatform.needs.weight = #{weight},tradeplatform.needs.view = #{view} where id = #{id}")
    Integer update(Tool tool);

    @Select("select * from needs where id = #{id}")
    Tool select(Integer id);
}
