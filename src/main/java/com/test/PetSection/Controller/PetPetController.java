package com.test.PetSection.Controller;

import com.test.PetSection.POJO.PageBean;
import com.test.PetSection.POJO.Result;
import com.test.PetSection.POJO.Pet;
import com.test.PetSection.Service.PetPetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class PetPetController {
    @Autowired
    private PetPetService PetPetService;

    //查询全部数据
    @GetMapping("/PetPet")
    private Result list(){
        log.info("查询全部数据");
        List<Pet> petList = PetPetService.list();
        return Result.Success(petList);
    }
    //根据id查询单条数据
    @GetMapping("/PetPet/{id}")
    private Result select(@PathVariable Integer id){
        log.info("查询id为{}数据",id);
        Pet pet = PetPetService.select(id);
        if(pet != null)
            return Result.Success(pet);
        else return Result.Error("No id");
    }
    //根据id删除单条数据
    @DeleteMapping("/PetPet/{id}")
    private Result delete(@PathVariable Integer id){
        log.info("删除id为{}数据",id);
        Integer code = PetPetService.delete(id);
        if(code == 1)
            return Result.Success(code);
        else return Result.Error("No id");
    }
    //新增单条数据
    @PostMapping("/PetPet")
    public Result insert(Pet pet){
        log.info("插入数据{}",pet);
        Integer code = PetPetService.insert(pet);
        if(code == 1)
            return Result.Success();
        else return Result.Error("all ready exist");
    }

    //    条件分页
    @GetMapping("/PetPetPage")
    public Result Selectpage(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "5") Integer pagesize,
                             String name,
                             Integer ishot,
                             @RequestParam(defaultValue = "0") Integer BeginPrice,
                             @RequestParam(defaultValue = "2147483647") Integer EndPrice){
        log.info("条件分页:{},{}",page,pagesize);
        Integer start = (page-1)*pagesize;
        if(page <=0||pagesize<0)return Result.Error("Must be Positive");
        PageBean pageBean = PetPetService.selectpage(start,pagesize,name,ishot,BeginPrice,EndPrice);
        return Result.Success(pageBean);
    }
//    修改文件
    @PostMapping("/PetPet/update")
    public Result update(Pet pet){
        log.info("更新数据:{}",pet);
        Integer code = PetPetService.update(pet);
        if(code == 1)
            return Result.Success();
        else return Result.Error("No id");
    }

}
