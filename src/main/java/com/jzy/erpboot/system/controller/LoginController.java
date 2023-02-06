package com.jzy.erpboot.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jzy.erpboot.system.common.ActiveUser;
import com.jzy.erpboot.system.common.Constant;
import com.jzy.erpboot.system.common.MenuTreeNode;
import com.jzy.erpboot.system.common.ResultObj;
import com.jzy.erpboot.system.domain.Menu;
import com.jzy.erpboot.system.domain.User;
import com.jzy.erpboot.system.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Controller
@RequestMapping("login")
public class LoginController {

    @Resource
    private MenuService menuService;


    /**
     * 用户登陆
     */
    @RequestMapping("doLogin")
    @ResponseBody
    public ResultObj doLogin(String loginname, String password) {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken loginToken = new UsernamePasswordToken(loginname, password);
            subject.login(loginToken);
//            ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
            //得到shiro的sessionid==token
            String token = subject.getSession().getId().toString();
            //TODO 写入登陆日志
            return new ResultObj(200, "登陆成功", token);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return new ResultObj(-1, "用户名不存在");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            return new ResultObj(-1, "密码不正确");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new ResultObj(-1, "用户名或密码不正确");
        }
    }

    /**
     * 返回验证码
     */

    /**
     * 加载所有菜单【顶部菜单，左侧菜单】
     */
    @RequestMapping("/loadIndexMenu")
    @ResponseBody
    public Object loadIndexMenu() {
        //如果是超级管理员则默认加载所有菜单
        //如果不是则按角色加载

        Subject subject = SecurityUtils.getSubject();
        ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
        User user = activeUser.getUser();
        if (null == user) {
            return null;
        }

        List<Menu> menus = null;

        //判断是不是超级管理员
        if (user.getType().equals(Constant.USER_TYPE_SUPER)) {
            //超级管理员
            menus = menuService.queryAllMenuForList();
        } else {
            //普通用户
            menus = menuService.queryMenuForListByUserId(user.getId());
        }

        List<MenuTreeNode> menuTreeNodes = new ArrayList<>();
        for (Menu menu:menus) {
            Boolean spread = menu.getSpread() == Constant.SPREAD_TRUE ? true:false;
            menuTreeNodes.add(new MenuTreeNode(menu.getId(),menu.getPid(),menu.getTitle(),menu.getHref(),menu.getIcon(),spread,menu.getTarget(),menu.getTypeCode()));
        }

        List<MenuTreeNode> nodes = MenuTreeNode.MenuTreeNodeBuilder.build(menuTreeNodes, 0);
        Map<String,Object> nodesMap = new HashMap<>();
        for (MenuTreeNode menu:nodes) {
            nodesMap.put(menu.getTypecode(),menu);
        }


        return nodesMap;
    }
}
