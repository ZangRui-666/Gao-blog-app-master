package com.ks.blog.service;

import com.ks.blog.vo.params.CategoryVo;
import com.ks.blog.vo.params.Result.Result;

public interface CategoryService {

    /**
     * 查询类别
     * @param categoryId
     * @return
     */
    CategoryVo findCategoryById(Long categoryId);

    /**
     * 查询全部类别
     * @return
     */
    Result findAll();

    Result findAllDetails();

    Result categoryDetailById(Long id);
}
