package com.test.User.Controller;

import com.test.User.POJO.Pack;
import com.test.User.POJO.Result;
import com.test.User.POJO.User;
import com.test.User.Service.UserService;
import com.test.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        log.info("尝试登录用户:{}",user.getUsername());
        User tmp = userService.login(user);
        if(tmp!=null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("username",tmp.getUsername());
            claims.put(("role"),tmp.getRole());
            System.out.println(claims);
            String jwt = JWTUtils.genToken(claims);
            log.info("get token");
            Pack pack = new Pack(jwt,tmp.getRole());
            return Result.Success(pack);
        }else return Result.Error("账号或密码错误");
    }
}
