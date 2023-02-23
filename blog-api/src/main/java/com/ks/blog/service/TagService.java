package com.ks.blog.service;

import com.ks.blog.pojo.Tag;
import com.ks.blog.vo.params.Result.Result;
import com.ks.blog.vo.params.TagVo;

import java.util.List;

public interface TagService {

    List<TagVo> findTagsByArticleId(Long articledId);

    Result hots(int limit);

    Result findAll();

    Result findTagsByIdl(Long id);

}
