package com.jzy.erpboot.system.service;

import com.jzy.erpboot.system.domain.User;

public interface UserService {
    /**
     * 根据用户登陆名查询用户信息
     */
    User queryUserByLoginName(String loginname);
}
