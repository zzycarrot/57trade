package com.test.AccountSection.Controller;

import com.test.AccountSection.POJO.PageBean;
import com.test.AccountSection.POJO.Result;
import com.test.AccountSection.POJO.Tool;
import com.test.AccountSection.Service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    //查询全部数据
    @GetMapping("/account")
    private Result list(){
        log.info("查询全部数据");
        List<Tool> toolList = accountService.list();
        return Result.Success(toolList);
    }
    //根据id查询单条数据
    @GetMapping("/account/{id}")
    private Result select(@PathVariable Integer id){
        log.info("查询id为{}数据",id);
        Tool tool = accountService.select(id);
        if(tool != null)
            return Result.Success(tool);
        else return Result.Error("No id");
    }
    //根据id删除单条数据
    @DeleteMapping("/account/{id}")
    private Result delete(@PathVariable Integer id){
        log.info("删除id为{}数据",id);
        Integer code = accountService.delete(id);
        if(code == 1)
            return Result.Success(code);
        else return Result.Error("No id");
    }
    //新增单条数据
    @PostMapping("/account")
    public Result insert(Tool tool){
        log.info("插入数据{}",tool);
        Integer code = accountService.insert(tool);
        if(code == 1)
            return Result.Success();
        else return Result.Error("all ready exist");
    }

    //    条件分页
    @GetMapping("/accountPage")
    public Result Selectpage(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "5") Integer pagesize,
                             String name,
                             Integer ishot,
                             @RequestParam(defaultValue = "0") Integer BeginPrice,
                             @RequestParam(defaultValue = "2147483647") Integer EndPrice){
        log.info("条件分页:{},{}",page,pagesize);
        Integer start = (page-1)*pagesize;
        if(page <=0||pagesize<0)return Result.Error("Must be Positive");
        PageBean pageBean = accountService.selectpage(start,pagesize,name,ishot,BeginPrice,EndPrice);
        return Result.Success(pageBean);
    }
//    修改文件
    @PostMapping("/account/update")
    public Result update(Tool tool){
        log.info("更新数据:{}",tool);
        Integer code = accountService.update(tool);
        if(code == 1)
            return Result.Success();
        else return Result.Error("No id");
    }

}
