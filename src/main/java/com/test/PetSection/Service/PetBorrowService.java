package com.test.PetSection.Service;

import com.test.PetSection.POJO.PageBean;
import com.test.PetSection.POJO.Pet;
import com.test.PetSection.POJO.PetRent;

import java.util.List;


public interface PetBorrowService {
    List<PetRent> list();

    Integer delete(Integer id);

    Integer insert(PetRent petRent);

    PageBean selectpage(Integer start, Integer pagesize, String name, Integer ishot, Integer beginPrice, Integer endPrice);

    Integer update(PetRent petRent);

    PetRent select(Integer id);
}
