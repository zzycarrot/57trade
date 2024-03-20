package com.test.Bar.Controller;

import com.test.Bar.POJO.PageBean;
import com.test.Bar.POJO.Result;
import com.test.Bar.POJO.Tool;
import com.test.Bar.Service.NeedsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class NeedsController {
    @Autowired
    private NeedsService needsService;

    //查询全部数据
    @GetMapping("/needs")
    private Result list(){
        log.info("查询全部数据");
        List<Tool> toolList = needsService.list();
        return Result.Success(toolList);
    }
    //根据id查询单条数据
    @GetMapping("/needs/{id}")
    private Result select(@PathVariable Integer id){
        log.info("查询id为{}数据",id);
        Tool tool = needsService.select(id);
        if(tool != null)
            return Result.Success(tool);
        else return Result.Error("No id");
    }
    //根据id删除单条数据
    @DeleteMapping("/needs/{id}")
    private Result delete(@PathVariable Integer id){
        log.info("删除id为{}数据",id);
        Integer code = needsService.delete(id);
        if(code == 1)
            return Result.Success(code);
        else return Result.Error("No id");
    }
    //新增单条数据
    @PostMapping("/needs")
    public Result insert(Tool tool){
        log.info("插入数据{}",tool);
        Integer code = needsService.insert(tool);
        if(code == 1)
            return Result.Success();
        else return Result.Error("all ready exist");
    }

    //    条件分页
    @GetMapping("/needsPage")
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
        PageBean pageBean = needsService.selectpage(start,pagesize,name,ishot,latest,cost,BeginPrice,EndPrice);
        return Result.Success(pageBean);
    }
//    修改文件
    @PostMapping("/needs/update")
    public Result update(Tool tool){
        log.info("更新数据:{}",tool);
        Integer code = needsService.update(tool);
        if(code == 1)
            return Result.Success();
        else return Result.Error("No id");
    }

}
