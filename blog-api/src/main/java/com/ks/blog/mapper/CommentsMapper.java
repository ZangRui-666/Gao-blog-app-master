package com.ks.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ks.blog.pojo.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsMapper extends BaseMapper<Comment> {
}
