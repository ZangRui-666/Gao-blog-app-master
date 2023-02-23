package com.ks.blog.service;

import com.ks.blog.vo.params.CommentParam;
import com.ks.blog.vo.params.Result.Result;

public interface CommentsService {
    /**
     * 根据文章id 查询所有的评论列表
     * @param id
     * @return
     */
    Result commentsByArticleId(Long id);

    /**
     *
     * @param commentParam
     * @return
     */
    Result comment(CommentParam commentParam);

}
