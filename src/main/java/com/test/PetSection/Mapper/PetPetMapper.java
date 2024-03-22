package com.test.PetSection.Mapper;

import com.test.PetSection.POJO.Pet;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PetPetMapper {


    @Select("select count(*) from PetPet")
    Integer count() ;

    public List<Pet> list() ;

    @Delete("delete from PetPet where id = #{id}")
    Integer delete(Integer id);

    @Insert("INSERT into PetPet (tradeplatform.PetPet.name, tradeplatform.PetPet.price, tradeplatform.PetPet.qq,tradeplatform.PetPet.description ,tradeplatform.PetPet.image, tradeplatform.PetPet.create_time, tradeplatform.PetPet.update_time, tradeplatform.PetPet.weight, tradeplatform.PetPet.view) " +
            " values(#{name},#{price},#{qq},#{description},#{image},#{createTime},#{updateTime},#{weight},#{view})")
    void insert(Pet pet);

    List<Pet> selectpage(Integer start, Integer pagesize, String name, Integer ishot,Integer latest,Integer cost, Integer beginPrice, Integer endPrice);
     @Update("update PetPet set name = #{name},price = #{price},qq = #{qq},description=#{description},image = #{image},update_time = #{updateTime},weight = #{weight},view = #{view} where id = #{id}")
    Integer update(Pet pet);
     @Select("select * from PetPet where id = #{id}")
    Pet select(Integer id);
}
