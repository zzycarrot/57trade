package com.test.ToolSection.Controller;

import com.test.ToolSection.POJO.PageBean;
import com.test.ToolSection.POJO.Result;
import com.test.ToolSection.POJO.Tool;
import com.test.ToolSection.Service.ToolPetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class ToolPetController {
    @Autowired
    private ToolPetService toolPetService;

    //查询全部数据
    @GetMapping("/ToolPet")
    private Result list(){
        log.info("查询全部数据");
        List<Tool> toolList = toolPetService.list();
        return Result.Success(toolList);
    }
    //根据id查询单条数据
    @GetMapping("/ToolPet/{id}")
    private Result select(@PathVariable Integer id){
        log.info("查询id为{}数据",id);
        Tool tool = toolPetService.select(id);
        if(tool != null)
            return Result.Success(tool);
        else return Result.Error("No id");
    }
    //根据id删除单条数据
    @DeleteMapping("/ToolPet/{id}")
    private Result delete(@PathVariable Integer id){
        log.info("删除id为{}数据",id);
        Integer code = toolPetService.delete(id);
        if(code == 1)
            return Result.Success(code);
        else return Result.Error("No id");
    }
    //新增单条数据
    @PostMapping("/ToolPet")
    public Result insert(Tool tool){
        log.info("插入数据{}",tool);
        Integer code = toolPetService.insert(tool);
        if(code == 1)
            return Result.Success();
        else return Result.Error("all ready exist");
    }

    //    条件分页
    @GetMapping("/ToolPetPage")
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
        PageBean pageBean = toolPetService.selectpage(start,pagesize,name,ishot,latest,cost,BeginPrice,EndPrice);
        return Result.Success(pageBean);
    }
//    修改文件
    @PostMapping("/ToolPet/update")
    public Result update(Tool tool){
        log.info("更新数据:{}",tool);
        Integer code = toolPetService.update(tool);
        if(code == 1)
            return Result.Success();
        else return Result.Error("No id");
    }

}
