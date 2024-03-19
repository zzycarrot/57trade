package com.test.Bar.Controller;

import com.test.Bar.POJO.PageBean;
import com.test.Bar.POJO.Result;
import com.test.Bar.POJO.Tool;
import com.test.Bar.Service.SubstituteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class SubstituteController {
    @Autowired
    private SubstituteService substituteService;

    //查询全部数据
    @GetMapping("/substitute")
    private Result list(){
        log.info("查询全部数据");
        List<Tool> toolList = substituteService.list();
        return Result.Success(toolList);
    }
    //根据id查询单条数据
    @GetMapping("/substitute/{id}")
    private Result select(@PathVariable Integer id){
        log.info("查询id为{}数据",id);
        Tool tool = substituteService.select(id);
        if(tool != null)
            return Result.Success(tool);
        else return Result.Error("No id");
    }
    //根据id删除单条数据
    @DeleteMapping("/substitute/{id}")
    private Result delete(@PathVariable Integer id){
        log.info("删除id为{}数据",id);
        Integer code = substituteService.delete(id);
        if(code == 1)
            return Result.Success(code);
        else return Result.Error("No id");
    }
    //新增单条数据
    @PostMapping("/substitute")
    public Result insert(Tool tool){
        log.info("插入数据{}",tool);
        Integer code = substituteService.insert(tool);
        if(code == 1)
            return Result.Success();
        else return Result.Error("all ready exist");
    }

    //    条件分页
    @GetMapping("/substitutePage")
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
        PageBean pageBean = substituteService.selectpage(start,pagesize,name,ishot,latest,cost,BeginPrice,EndPrice);
        return Result.Success(pageBean);
    }
//    修改文件
    @PostMapping("/substitute/update")
    public Result update(Tool tool){
        log.info("更新数据:{}",tool);
        Integer code = substituteService.update(tool);
        if(code == 1)
            return Result.Success();
        else return Result.Error("No id");
    }

}
