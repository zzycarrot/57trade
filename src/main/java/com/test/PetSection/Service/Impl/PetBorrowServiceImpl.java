package com.test.PetSection.Service.Impl;

import com.test.PetSection.Mapper.PetBorrowMapper;
import com.test.PetSection.POJO.PageBean;
import com.test.PetSection.POJO.Pet;
import com.test.PetSection.POJO.PetRent;
import com.test.PetSection.Service.PetBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PetBorrowServiceImpl implements PetBorrowService {
    @Autowired
    private PetBorrowMapper PetBorrowMapper;
    @Override
    public List<PetRent> list() {

        return PetBorrowMapper.list();
    }

    @Override
    public Integer delete(Integer id) {
        return PetBorrowMapper.delete(id);
    }

    @Override
    public Integer insert(PetRent petRent) {
        petRent.setCreateTime(LocalDateTime.now());
        petRent.setUpdateTime(LocalDateTime.now());
        if(petRent.getWeight()==null)petRent.setWeight(3);
        if(petRent.getView()==null)petRent.setView(0);
        PetBorrowMapper.insert(petRent);
        return 1;
    }

    @Override
    public PageBean selectpage(Integer start, Integer pagesize, String name, Integer ishot, Integer beginPrice, Integer endPrice) {
        Integer total;
        List<PetRent> list= PetBorrowMapper.selectpage(start,pagesize,name,ishot,beginPrice,endPrice);
        total = list.size();
        PageBean pageBean = new PageBean(total,list);
        return pageBean;
    }

    @Override
    public Integer update(PetRent petRent) {
        petRent.setUpdateTime(LocalDateTime.now());
        if(petRent.getWeight()==null)petRent.setWeight(3);
        if(petRent.getView()==null)petRent.setView(0);
        return PetBorrowMapper.update(petRent);
    }

    @Override
    public PetRent select(Integer id) {
        return PetBorrowMapper.select(id);
    }
}
