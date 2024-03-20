package com.test.AccountSection.Mapper;

import com.test.AccountSection.POJO.Tool;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountMapper {


    @Select("select count(*) from account")
    Integer count();

    public List<Tool> list() ;

    @Delete("delete from account where id = #{id}")
    Integer delete(Integer id);

    @Insert("INSERT into account (tradeplatform.account.name, tradeplatform.account.price, tradeplatform.account.qq, tradeplatform.account.image, tradeplatform.account.create_time, tradeplatform.account.update_time, tradeplatform.account.weight, tradeplatform.account.view) " +
            " values(#{name},#{price},#{qq},#{image},#{createTime},#{updateTime},#{weight},#{view})")
    void insert(Tool tool);

    List<Tool> selectpage(Integer start, Integer pagesize, String name, Integer ishot,Integer latest,Integer cost, Integer beginPrice, Integer endPrice);

    @Update("update account set tradeplatform.account.name = #{name},tradeplatform.account.price = #{price},tradeplatform.account.qq = #{qq},tradeplatform.account.image = #{image},tradeplatform.account.update_time = #{updateTime},tradeplatform.account.weight = #{weight},tradeplatform.account.view = #{view} where id = #{id}")
    Integer update(Tool tool);

    @Select("select * from account where id = #{id}")
    Tool select(Integer id);
}
