package com.jzy.erpboot.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

        return null;
    }

    /**
     * @param id 用户ID
     * @return
     */
    @Override
    public List<Menu> queryMenuForListByUserId(Integer id) {

        return null;
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
