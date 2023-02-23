package com.ks.blog.service;

import com.ks.blog.pojo.SysUser;
import com.ks.blog.vo.params.LoginParam;
import com.ks.blog.vo.params.Result.Result;

public interface LoginService {
    Result login(LoginParam loginParam);

    /**
     *
     * @param token
     * @return
     */
    SysUser checkToken(String token);

    //退出登陆
    Result logout(String token);

    //注册
    Result register(LoginParam loginParam);
}
