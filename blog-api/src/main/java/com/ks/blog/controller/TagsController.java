package com.ks.blog.controller;

import com.ks.blog.service.TagService;
import com.ks.blog.vo.params.Result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagsController {

    @Autowired
    private TagService tagService;
    // /tags/hot
    @GetMapping("/hot")
    public Result hot(){
        int limit = 6;
        return tagService.hots(limit);
    }

    @GetMapping
    public Result findTags(){
        return tagService.findAll();
    }

    @GetMapping("/detail")
    public Result findAll(){
        return tagService.findAll();
    }

    @GetMapping("/detail/{id}")
    public Result findTagsById(@PathVariable("id") Long id){
        return tagService.findTagsByIdl(id);
    }

}
