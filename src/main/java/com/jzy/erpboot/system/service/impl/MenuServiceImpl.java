package com.jzy.erpboot.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jzy.erpboot.system.common.Constant;
import com.jzy.erpboot.system.common.DataGridView;
import com.jzy.erpboot.system.domain.Menu;
import com.jzy.erpboot.system.mapper.MenuMapper;
import com.jzy.erpboot.system.service.MenuService;
import com.jzy.erpboot.system.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public List<Menu> queryAllMenuForList() {
        //使用mybatisplus查询，available状态为1可用，并且type为顶层菜单(topmenu)或者左侧菜单(leftmenu)
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.eq("available", Constant.AVAILABLE_TRUE);
        wrapper.and(new Consumer<QueryWrapper<Menu>>() {
            @Override
            public void accept(QueryWrapper<Menu> menuQueryWrapper) {
                menuQueryWrapper.eq("type", Constant.MENU_TYPE_TOP).or().eq("type", Constant.MENU_TYPE_LEFT);
            }
        });
        wrapper.orderByAsc("ordernum");
        return this.menuMapper.selectList(wrapper);
    }

    /**
     * @param id 用户ID
     * @return
     */
    @Override
    public List<Menu> queryMenuForListByUserId(Integer id) {
        //使用mybatisplus查询，available状态为1可用，并且type为顶层菜单(topmenu)或者左侧菜单(leftmenu)
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.eq("available", Constant.AVAILABLE_TRUE);
        wrapper.and(new Consumer<QueryWrapper<Menu>>() {
            @Override
            public void accept(QueryWrapper<Menu> menuQueryWrapper) {
                menuQueryWrapper.eq("type", Constant.MENU_TYPE_TOP).or().eq("type", Constant.MENU_TYPE_LEFT);
            }
        });
        wrapper.orderByAsc("ordernum");
        return this.menuMapper.selectList(wrapper);
    }

    @Override
    public DataGridView queryAllMenu(MenuVo menuVo) {

        return null;
    }

    @Override
    public Integer queryMenuMaxOrderNum() {
        return null;
    }

    @Override
    public Menu saveMenu(Menu menu) {
        return null;
    }

    @Override
    public Menu updateMenu(Menu menu) {
        return null;
    }

    @Override
    public Integer queryMenuChildrenCountById(Integer id) {
        return null;
    }

    @Override
    public List<String> queryPermissionCodesByUserId(Integer id) {
        return null;
    }
}
