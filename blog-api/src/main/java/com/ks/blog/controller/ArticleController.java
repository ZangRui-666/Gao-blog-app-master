package com.ks.blog.controller;

import com.ks.blog.common.aop.LogAnnotation;
import com.ks.blog.common.cache.Cache;
import com.ks.blog.service.ArticlesService;
import com.ks.blog.vo.params.ArticleParam;
import com.ks.blog.vo.params.PageParams;
import com.ks.blog.vo.params.Result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticlesService articlesService;
    /**
     * 首页文章列表
     * @param pageParams
     * @return
     */
    @PostMapping
    // 加上此注解 代表要对此接口记录日志
    @LogAnnotation(module="文章",operator="获取文章列表")
//    @Cache(expire = 5 * 60 * 1000,name = "listArticle")
    public Result listArticle(@RequestBody PageParams pageParams){
        return articlesService.listArticle(pageParams);
    }

    //首页最热文章
    @PostMapping("/hot")
//    @Cache(expire = 5 * 60 * 1000,name = "hot_article")
    public Result hotArticle(){
        int limit = 5;
        return articlesService.hotArticle(limit);
    }

    //最新文章
    @PostMapping("/new")
//    @Cache(expire = 5 * 60 * 1000,name = "news_article")
    public Result newArticles(){
        int limit = 5;
        return articlesService.newArticles(limit);
    }

    //文章归档
    @PostMapping("/listArchives")
    public Result listArchives(){
        return articlesService.listArchives();
    }

    @PostMapping("/view/{id}")
//    @Cache(expire = 5 * 60 * 1000,name = "view_article")
    public Result findArticleById(@PathVariable("id") Long articleId){
        return articlesService.findArticleById(articleId);
    }

    @PostMapping("/publish")
    public Result publish(@RequestBody ArticleParam articleParam){
        return articlesService.publish(articleParam);
    }
}
