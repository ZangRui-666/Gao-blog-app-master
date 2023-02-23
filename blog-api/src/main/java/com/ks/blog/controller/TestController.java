package com.ks.blog.controller;

import com.ks.blog.vo.params.Result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public Result test(){
        return Result.success(null);
    }
}
