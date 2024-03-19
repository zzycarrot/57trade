package com.test.PetSection.Mapper;

import com.test.PetSection.POJO.Pet;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PetRideMapper {


    public List<Pet> list() ;

    @Delete("delete from petride where id = #{id}")
    Integer delete(Integer id);

    @Insert("INSERT into petride (tradeplatform.petride.name, tradeplatform.petride.price, tradeplatform.petride.qq,tradeplatform.petride.description ,tradeplatform.petride.image, tradeplatform.petride.create_time, tradeplatform.petride.update_time, tradeplatform.petride.weight, tradeplatform.petride.view) " +
            " values(#{name},#{price},#{qq},#{description},#{image},#{createTime},#{updateTime},#{weight},#{view})")
    void insert(Pet pet);

    List<Pet> selectpage(Integer start, Integer pagesize, String name, Integer ishot, Integer beginPrice, Integer endPrice);
     @Update("update petride set name = #{name},price = #{price},qq = #{qq},description=#{description},image = #{image},update_time = #{updateTime},weight = #{weight},view = #{view} where id = #{id}")
    Integer update(Pet pet);
     @Select("select * from petride where id = #{id}")
    Pet select(Integer id);
}
