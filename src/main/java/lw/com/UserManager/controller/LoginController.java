package lw.com.UserManager.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import lw.com.UserManager.auth.JwtUtil;
import lw.com.UserManager.domain.login.dto.LoginParams;
import lw.com.UserManager.domain.login.entity.User;
import lw.com.UserManager.domain.login.vo.LoginResponse;
import lw.com.UserManager.service.impl.AlertUserServiceImpl;
import lw.com.UserManager.utils.Response;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

@Controller
@Slf4j
@RequestMapping("auth")
public class LoginController {
    @Autowired
    private JwtUtil jwtUtil;


    @Autowired
    private  AlertUserServiceImpl alertUserService;

    @GetMapping("login")
    public String loginPage() {
        return "login.html";
    }


    @PostMapping("doLogin")
    @ResponseBody
    public Object dologin(@RequestBody LoginParams loginParams, HttpServletResponse  response){
        log.warn("do login");
        var user = alertUserService.getOne(new LambdaQueryWrapper<User>().eq(User::getUsername,loginParams.getUsername()));
        if (Objects.isNull(user)) {
            return "用户不存在";
        }
        log.info("{}",user);
        String token = jwtUtil.generateToken(loginParams.getUsername());
        response.setHeader(JwtUtil.HEADER, token);
        response.setHeader("Access-control-Expost-Headers", JwtUtil.HEADER);
        return Response.Response_200(new LoginResponse(token));
    }
    @RequiresAuthentication
    @GetMapping("logout")
    public String logout() {
        // 退出登录
        SecurityUtils.getSubject().logout();
        return "登出成功";
    }

}
