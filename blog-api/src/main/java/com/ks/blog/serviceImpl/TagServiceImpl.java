package com.ks.blog.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ks.blog.mapper.TagMapper;
import com.ks.blog.pojo.Tag;
import com.ks.blog.service.TagService;
import com.ks.blog.vo.params.Result.Result;
import com.ks.blog.vo.params.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    private TagVo copy(Tag tag){
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        return tagVo;
    }

    private List<TagVo> copyList(List<Tag> tags){
        List<TagVo> tagVos = new ArrayList<>();
        for (Tag tag:tags){
            tagVos.add(copy(tag));
        }
        return tagVos;
    }

    @Override
    public List<TagVo> findTagsByArticleId(Long articledId) {
        //mybatisplus无法进行多表查询
        List<Tag> tags = tagMapper.findTagsByArticleId(articledId);
        return copyList(tags);
    }

    @Override
    public Result hots(int limit) {
        // 标签所拥有的文章数量最多 最热标签
        // 查询根据tag_id 分组 计数,从大到小排列 取前limit
        List<Long> tagIds = tagMapper.findHotsTagIds(limit);
        if (CollectionUtils.isEmpty(tagIds)){
            return  Result.success(Collections.emptyList());
        }
        //需求的是tagId和tagName Tag对象
        // select * from tag where id in ()
        List<Tag> tagList = tagMapper.findTagsByTagIds(tagIds);
        return Result.success(tagList);
    }

    @Override
    public Result findAll() {
        List<Tag> tags = tagMapper.selectList(new LambdaQueryWrapper<>());
        return Result.success(copyList(tags));
    }

    @Override
    public Result findTagsByIdl(Long id) {
        Tag tag = tagMapper.selectById(id);
        return Result.success(copy(tag));
    }
}
