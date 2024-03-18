package com.test.Interceptor;

import com.test.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override   //true 放行 ,false 不放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("PreHandler");

        String url = request.getRequestURL().toString();
        log.info("请求{}",url);
        if (url.contains("login,放行")){
            log.info("登陆操作");
            return true;
        }
        String jwt = request.getHeader("token");
        if(!StringUtils.hasLength(jwt)){
            log.info("token empty,不放行");

        }
        try{
            JWTUtils.checkToken(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("token 解析失败");
            return false;
        }

        Claims claims = JWTUtils.checkToken(jwt);
        String role = (String) claims.get("role");
        System.out.println(claims);
        System.out.println(role);
        if (url.contains("article"))return true;
        if(!role.contentEquals("admin")){
            ///
            log.info("无权限");
            return false;
        }

        log.info("token 合法放行");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("PostHandler");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("AfterHandler");
    }
}
