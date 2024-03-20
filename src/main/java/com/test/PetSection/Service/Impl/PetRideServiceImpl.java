package com.test.PetSection.Service.Impl;

import com.test.PetSection.Mapper.PetRideMapper;
import com.test.PetSection.POJO.PageBean;
import com.test.PetSection.POJO.Pet;
import com.test.PetSection.Service.PetRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PetRideServiceImpl implements PetRideService {
    @Autowired
    private PetRideMapper petRideMapper;
    @Override
    public List<Pet> list() {

        return petRideMapper.list();
    }

    @Override
    public Integer delete(Integer id) {
        return petRideMapper.delete(id);
    }

    @Override
    public Integer insert(Pet pet) {
        pet.setCreateTime(LocalDateTime.now());
        pet.setUpdateTime(LocalDateTime.now());
        if (pet.getDescription()==null)pet.setDescription("暂无描述");
        if(pet.getWeight()==null)pet.setWeight(3);
        if(pet.getView()==null)pet.setView(0);
        petRideMapper.insert(pet);
        return 1;
    }

    @Override
    public PageBean selectpage(Integer start, Integer pagesize, String name, Integer ishot, Integer beginPrice, Integer endPrice) {
        Integer total;
        List<Pet> list= petRideMapper.selectpage(start,pagesize,name,ishot,beginPrice,endPrice);
        total = petRideMapper.count();
        PageBean pageBean = new PageBean(total,list);
        return pageBean;
    }

    @Override
    public Integer update(Pet pet) {
        pet.setUpdateTime(LocalDateTime.now());
        if (pet.getDescription()==null)pet.setDescription("暂无描述");
        if(pet.getWeight()==null)pet.setWeight(3);
        if(pet.getView()==null)pet.setView(0);
        return petRideMapper.update(pet);
    }

    @Override
    public Pet select(Integer id) {
        return petRideMapper.select(id);
    }
}
