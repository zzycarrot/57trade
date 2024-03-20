package com.test.PetSection.Mapper;

import com.test.PetSection.POJO.Pet;
import com.test.PetSection.POJO.PetRent;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PetBorrowMapper {


    List<PetRent> list() ;

    @Delete("delete from PetBorrow where id = #{id}")
    Integer delete(Integer id);

    @Insert("insert into PetBorrow(name,week_price,month_price,deposit,qq,image,create_time,update_time,weight,view) values(#{name},#{weekPrice},#{monthPrice},#{deposit},#{qq},#{image},#{createTime},#{updateTime},#{weight},#{view})")
    void insert(PetRent petRent);

    List<PetRent> selectpage(Integer start, Integer pagesize, String name, Integer ishot,Integer latest,Integer cost, Integer beginPrice, Integer endPrice);

    @Update("update PetBorrow set name=#{name},week_price=#{weekPrice},month_price=#{monthPrice},deposit=#{deposit},qq=#{qq},image=#{image},update_time=#{updateTime},weight=#{weight},view=#{view} where id = #{id}")
    Integer update(PetRent petRent);
     @Select("select * from PetBorrow where id = #{id}")
    PetRent select(Integer id);

     @Select("select count(*) from PetBorrow")
    Integer count();
}
