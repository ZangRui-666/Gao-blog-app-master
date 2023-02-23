package com.ks.blog.vo.params;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @Author: gaonannan
 * @Date: 2022/3/14
 * @Description:构建评论参数对象
 */

@Data
public class CommentParam {


    private Long articleId;

    private String content;

    private Long parent;

    private Long toUserId;
}
