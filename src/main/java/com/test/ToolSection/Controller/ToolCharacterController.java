package com.test.ToolSection.Controller;

import com.test.ToolSection.POJO.Result;
import com.test.ToolSection.Service.ToolCharacterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.test.ToolSection.POJO.Tool;
import com.test.ToolSection.POJO.PageBean;
import com.test.ToolSection.POJO.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class ToolCharacterController {
    @Autowired
    private ToolCharacterService toolCharacterService;

    //查询全部数据
    @GetMapping("/ToolCharacter")
    private Result list(){
        log.info("查询全部数据");
        List<Tool> toolList = toolCharacterService.list();
        return Result.Success(toolList);
    }
    //根据id查询单条数据
    @GetMapping("/ToolCharacter/{id}")
    private Result select(@PathVariable Integer id){
        log.info("查询id为{}数据",id);
        Tool tool = toolCharacterService.select(id);
        if(tool != null)
            return Result.Success(tool);
        else return Result.Error("No id");
    }
    //根据id删除单条数据
    @DeleteMapping("/ToolCharacter/{id}")
    private Result delete(@PathVariable Integer id){
        log.info("删除id为{}数据",id);
        Integer code = toolCharacterService.delete(id);
        if(code == 1)
            return Result.Success(code);
        else return Result.Error("No id");
    }
    //新增单条数据
    @PostMapping("/ToolCharacter")
    public Result insert(Tool tool){
        log.info("插入数据{}",tool);
        Integer code = toolCharacterService.insert(tool);
        if(code == 1)
            return Result.Success();
        else return Result.Error("all ready exist");
    }

    //    条件分页
    @GetMapping("/ToolCharacterPage")
    public Result Selectpage(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "5") Integer pagesize,
                             String name,
                             Integer ishot,
                             @RequestParam(defaultValue = "0") Integer BeginPrice,
                             @RequestParam(defaultValue = "2147483647") Integer EndPrice){
        log.info("条件分页:{},{}",page,pagesize);
        Integer start = (page-1)*pagesize;
        if(page <=0||pagesize<0)return Result.Error("Must be Positive");
        PageBean pageBean = toolCharacterService.selectpage(start,pagesize,name,ishot,BeginPrice,EndPrice);
        return Result.Success(pageBean);
    }
//    修改文件
    @PostMapping("/ToolCharacter/update")
    public Result update(Tool tool){
        log.info("更新数据:{}",tool);
        Integer code = toolCharacterService.update(tool);
        if(code == 1)
            return Result.Success();
        else return Result.Error("No id");
    }
//    上传文件
    @PostMapping("/uploadFile")
    public Result uploadImg(@RequestParam("file") MultipartFile file, @RequestParam("equipmentId") String equipmentId) {
        String baseDir = "./imgFile";  // 这里不能直接使用相对路径
        //linux 环境下去掉点
        if (!file.isEmpty()) {
            String name = file.getOriginalFilename();
            String prefix = name.lastIndexOf(".") != -1 ? name.substring(name.lastIndexOf(".")) : ".jpg";
            String path = UUID.randomUUID().toString().replace("-", "") + prefix;
            try {
                // 这里代码都是没有问题的
                File filePath = new File(baseDir, path);
                // 第一次执行代码时，路径是不存在的
                log.info("文件保存路径：{}，是否存在：{}", filePath.getParentFile().exists(), filePath.getParent());
                if (!filePath.getParentFile().exists()) {   // 如果存放路径的父目录不存在，就创建它。
                    filePath.getParentFile().mkdirs();
                }
                // 如果路径不存在，上面的代码会创建路径，此时路径即已经创建好了
                log.info("文件保存路径：{}，是否存在：{}", filePath.getParentFile().exists(), filePath.getParent());
                // 此处使用相对路径，似乎是一个坑！
                // 相对路径：filePath
                // 绝对路径：filePath.getAbsoluteFile()
                log.info("文件将要保存的路径：{}", filePath.getPath());
                file.transferTo(filePath.getAbsoluteFile());
                log.info("文件成功保存的路径：{}", filePath.getAbsolutePath());
                return Result.Success(path);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return Result.Error("上传失败");
    }
}
