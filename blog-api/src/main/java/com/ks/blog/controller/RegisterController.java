package com.ks.blog.controller;

import com.ks.blog.service.LoginService;
import com.ks.blog.vo.params.LoginParam;
import com.ks.blog.vo.params.Result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result register(@RequestBody LoginParam loginParam){
        //sso单点登陆,后期如果把登陆注册功能 提出去 单独的服务可以独立提供接口服务
        return loginService.register(loginParam);
    }

}
