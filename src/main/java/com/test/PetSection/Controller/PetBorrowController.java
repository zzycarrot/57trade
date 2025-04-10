package com.test.PetSection.Controller;

import com.test.PetSection.POJO.Pet;
import com.test.PetSection.POJO.PetRent;
import com.test.PetSection.POJO.Result;
import com.test.PetSection.Service.PetBorrowService;
import com.test.PetSection.POJO.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class PetBorrowController {
    @Autowired
    private PetBorrowService petBorrowService;

    //查询全部数据
    @GetMapping("/PetBorrow")
    private Result list(){
        log.info("查询全部数据");
        List<PetRent> petList = petBorrowService.list();
        return Result.Success(petList);
    }
    //根据id查询单条数据
    @GetMapping("/PetBorrow/{id}")
    private Result select(@PathVariable Integer id){
        log.info("查询id为{}数据",id);
        PetRent petRent = petBorrowService.select(id);
        if(petRent != null)
            return Result.Success(petRent);
        else return Result.Error("No id");
    }
    //根据id删除单条数据
    @DeleteMapping("/PetBorrow/{id}")
    private Result delete(@PathVariable Integer id){
        log.info("删除id为{}数据",id);
        Integer code = petBorrowService.delete(id);
        if(code == 1)
            return Result.Success(code);
        else return Result.Error("No id");
    }
    //新增单条数据
    @PostMapping("/PetBorrow")
    public Result insert(PetRent petRent){
        log.info("插入数据{}",petRent);
        Integer code = petBorrowService.insert(petRent);
        if(code == 1)
            return Result.Success();
        else return Result.Error("all ready exist");
    }

    //    条件分页
    @GetMapping("/PetBorrowPage")
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
        PageBean pageBean = petBorrowService.selectpage(start,pagesize,name,ishot,latest,cost,BeginPrice,EndPrice);
        return Result.Success(pageBean);
    }
//    修改文件
    @PostMapping("/PetBorrow/update")
    public Result update(PetRent petRent){
        log.info("更新数据:{}",petRent);
        Integer code = petBorrowService.update(petRent);
        if(code == 1)
            return Result.Success();
        else return Result.Error("No id");
    }

}
