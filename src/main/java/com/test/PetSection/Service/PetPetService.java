package com.test.PetSection.Service;

import com.test.PetSection.POJO.PageBean;
import com.test.PetSection.POJO.Pet;

import java.util.List;


public interface PetPetService {
    List<Pet> list();

    Integer delete(Integer id);

    Integer insert(Pet pet);

    PageBean selectpage(Integer start, Integer pagesize, String name, Integer ishot, Integer latest,Integer cost,Integer beginPrice, Integer endPrice);

    Integer update(Pet pet);

    Pet select(Integer id);
}
