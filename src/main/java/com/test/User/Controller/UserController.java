package com.test.User.Controller;

import com.test.User.POJO.Result;
import com.test.User.POJO.User;
import com.test.User.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("User")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("selectAll")
    public Result selectAll(){
        log.info("selectAll");
        List<User> users=userService.selectAll();
        return Result.Success(users);
    }
    @PostMapping("insert")
    public Result insert(@RequestBody User user){

        user.setRole("emp");
        log.info("insert:{}",user);
        userService.insert(user);
        return  Result.Success("插入成功");
    }
    @DeleteMapping("delete")
    public Result delete(String username){
        log.info("delete:{}",username);
        User user = userService.select(username);
        if(user != null) {
            if (user.getRole().equals("admin")) {
                return Result.Error("无法删除管理员");
            }
        }
        Integer code = userService.delete(username);
        if(code == 1)return Result.Success("删除成功");
        else return Result.Error("不存在该用户");
    }
}
