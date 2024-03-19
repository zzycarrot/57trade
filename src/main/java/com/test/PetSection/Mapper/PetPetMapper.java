package com.test.PetSection.Mapper;

import com.test.PetSection.POJO.Pet;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PetPetMapper {


    public List<Pet> list() ;

    @Delete("delete from petpet where id = #{id}")
    Integer delete(Integer id);

    @Insert("INSERT into petpet (tradeplatform.petpet.name, tradeplatform.petpet.price, tradeplatform.petpet.qq,tradeplatform.petpet.description ,tradeplatform.petpet.image, tradeplatform.petpet.create_time, tradeplatform.petpet.update_time, tradeplatform.petpet.weight, tradeplatform.petpet.view) " +
            " values(#{name},#{price},#{qq},#{description},#{image},#{createTime},#{updateTime},#{weight},#{view})")
    void insert(Pet pet);

    List<Pet> selectpage(Integer start, Integer pagesize, String name, Integer ishot, Integer beginPrice, Integer endPrice);
     @Update("update petpet set name = #{name},price = #{price},qq = #{qq},description=#{description},image = #{image},update_time = #{updateTime},weight = #{weight},view = #{view} where id = #{id}")
    Integer update(Pet pet);
     @Select("select * from petpet where id = #{id}")
    Pet select(Integer id);
}
