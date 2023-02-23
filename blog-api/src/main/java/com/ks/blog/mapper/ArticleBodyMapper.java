package com.ks.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ks.blog.pojo.ArticleBody;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleBodyMapper extends BaseMapper<ArticleBody> {
}
