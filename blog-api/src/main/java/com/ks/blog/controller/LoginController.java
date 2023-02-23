package com.ks.blog.controller;

import com.ks.blog.service.LoginService;
import com.ks.blog.vo.params.LoginParam;
import com.ks.blog.vo.params.Result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

//    @Autowired
//    private SysUserService sysUserService;
//
//            final HttpHeaders headers = new HttpHeaders();
// 地址直接请求
//            headers.setContentType(MediaType.IMAGE_PNG);
    @Autowired
    private LoginService loginService;


    @PostMapping
    public Result login(@RequestBody LoginParam loginParam){
        //登陆 验证用户 访问用户表,但是
        return loginService.login(loginParam);
    }
}
