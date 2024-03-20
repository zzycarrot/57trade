package com.test.PetSection.Controller;

import com.test.PetSection.POJO.PageBean;
import com.test.PetSection.POJO.Pet;
import com.test.PetSection.POJO.Result;
import com.test.PetSection.Service.PetRideService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class PetRideController {
    @Autowired
    private PetRideService petRideService;

    //查询全部数据
    @GetMapping("/PetRide")
    private Result list(){
        log.info("查询全部数据");
        List<Pet> petList = petRideService.list();
        return Result.Success(petList);
    }
    //根据id查询单条数据
    @GetMapping("/PetRide/{id}")
    private Result select(@PathVariable Integer id){
        log.info("查询id为{}数据",id);
        Pet pet = petRideService.select(id);
        if(pet != null)
            return Result.Success(pet);
        else return Result.Error("No id");
    }
    //根据id删除单条数据
    @DeleteMapping("/PetRide/{id}")
    private Result delete(@PathVariable Integer id){
        log.info("删除id为{}数据",id);
        Integer code = petRideService.delete(id);
        if(code == 1)
            return Result.Success(code);
        else return Result.Error("No id");
    }
    //新增单条数据
    @PostMapping("/PetRide")
    public Result insert(Pet pet){
        log.info("插入数据{}",pet);
        Integer code = petRideService.insert(pet);
        if(code == 1)
            return Result.Success();
        else return Result.Error("all ready exist");
    }

    //    条件分页
    @GetMapping("/PetRidePage")
    public Result Selectpage(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "5") Integer pagesize,
                             String name,
                             Integer ishot,
                             Integer latest,
                             Integer cost,
                             @RequestParam(defaultValue = "0") Integer BeginPrice,
                             @RequestParam(defaultValue = "2147483647") Integer EndPrice){
        log.info("条件分页:{},{}",page,pagesize);
        Integer start = (page-1)*pagesize;
        if(page <=0||pagesize<0)return Result.Error("Must be Positive");
        System.out.println("diao yong le selectpage");
        PageBean pageBean = petRideService.selectpage(start,pagesize,name,ishot,latest,cost,BeginPrice,EndPrice);
        System.out.println("diao yong wan selectpage");
        return Result.Success(pageBean);
    }
//    修改文件
    @PostMapping("/PetRide/update")
    public Result update(Pet pet){
        log.info("更新数据:{}",pet);
        Integer code = petRideService.update(pet);
        if(code == 1)
            return Result.Success();
        else return Result.Error("No id");
    }

}
