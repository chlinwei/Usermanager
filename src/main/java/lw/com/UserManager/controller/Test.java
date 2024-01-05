package lw.com.UserManager.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Test {
    @RequiresAuthentication
    @GetMapping("/test")
    public  String sayHello() {
        return "test.html";
    }


    @GetMapping("/index")
    public String index() {
        return "index.html";
    }
}

