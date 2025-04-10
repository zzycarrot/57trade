package com.test.PetSection.Service.Impl;

import com.test.Delete.DeleteImage;
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
    private PetBorrowMapper petBorrowMapper;
    @Override
    public List<PetRent> list() {

        return petBorrowMapper.list();
    }

    @Override
    public Integer delete(Integer id) {
        String image = petBorrowMapper.select(id).getImage();
        if(image != null){
            String path = "/root/pic";
            DeleteImage deleteImage = new DeleteImage();
            deleteImage.deleteImage(image);
        }
        return petBorrowMapper.delete(id);
    }

    @Override
    public Integer insert(PetRent petRent) {
        petRent.setCreateTime(LocalDateTime.now());
        petRent.setUpdateTime(LocalDateTime.now());
        if(petRent.getWeight()==null)petRent.setWeight(3);
        if(petRent.getView()==null)petRent.setView(0);
        petBorrowMapper.insert(petRent);
        return 1;
    }

    @Override
    public PageBean selectpage(Integer start, Integer pagesize, String name, Integer ishot,Integer latest,Integer cost, Integer beginPrice, Integer endPrice) {
        Integer total;
        List<PetRent> list= petBorrowMapper.selectpage(start,pagesize,name,ishot,latest,cost,beginPrice,endPrice);
        total = petBorrowMapper.count();
        PageBean pageBean = new PageBean(total,list);
        return pageBean;
    }

    @Override
    public Integer update(PetRent petRent) {
        petRent.setUpdateTime(LocalDateTime.now());
        if(petRent.getWeight()==null)petRent.setWeight(3);
        if(petRent.getView()==null)petRent.setView(0);
        return petBorrowMapper.update(petRent);
    }

    @Override
    public PetRent select(Integer id) {
        return petBorrowMapper.select(id);
    }
}
