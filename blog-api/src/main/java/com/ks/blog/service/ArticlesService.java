package com.ks.blog.service;

import com.ks.blog.vo.params.ArticleParam;
import com.ks.blog.vo.params.PageParams;
import com.ks.blog.vo.params.Result.Result;

public interface ArticlesService {
    /**
     * 分页查询文章列表
     * @param pageParams
     * @return
     */
    Result listArticle(PageParams pageParams);

    //最热文章
    Result hotArticle(int limit);

    //最新文章
    Result newArticles(int limit);

    //文章归档
    Result listArchives();

    /**
     * 查看文章详情
     * @return
     */
    Result findArticleById(Long articleId);

    /**
     * 发布文章
     * @param articleParam
     * @return
     */
    Result publish(ArticleParam articleParam);
}
