package com.ks.blog.service;

import com.ks.blog.pojo.SysUser;
import com.ks.blog.vo.params.Result.Result;
import com.ks.blog.vo.params.UserVo;

public interface SysUserService {

    UserVo findUserVoById(Long id);

    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);

    /**
     * 根据token查询用户信息
     * @param token
     * @return
     */
    Result findUserByToken(String token);

    //根据账户查找用户
    SysUser findUserByAccount(String account);

    //保存用户
    void save(SysUser sysUser);
}
