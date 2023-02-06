package com.jzy.erpboot.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jzy.erpboot.system.domain.User;
import com.jzy.erpboot.system.mapper.UserMapper;
import com.jzy.erpboot.system.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    private Log log = LogFactory.getLog(UserServiceImpl.class);

    @Override
    public User queryUserByLoginName(String loginname) {
        UserMapper userMapper = this.getBaseMapper();
        QueryWrapper<User> qw = new QueryWrapper<>();
        if (StringUtils.isBlank(loginname)){
            log.error("登陆名不能为空");
        }
        //查询loginname等于传值的loginname
        qw.eq("loginname",loginname);
        //查询loginname不为空的
        qw.isNotNull("loginname");
        User user = userMapper.selectOne(qw);
        return user;
    }
}
