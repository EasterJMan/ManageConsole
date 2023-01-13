package com.jzy.erpboot.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jzy.erpboot.system.common.DataGridView;
import com.jzy.erpboot.system.domain.Menu;
import com.jzy.erpboot.system.vo.MenuVo;

import java.util.List;

public interface MenuService extends IService<Menu>{


    /**
     * 全查询菜单
     * @return
     */
    List<Menu> queryAllMenuForList();

    /**
     * 根据用户ID查询菜单
     * @param id
     * @return
     */
    List<Menu> queryMenuForListByUserId(Integer id);

    DataGridView queryAllMenu(MenuVo menuVo);

    Integer queryMenuMaxOrderNum();

    Menu saveMenu(Menu menu);

    Menu updateMenu(Menu menu);

    Integer queryMenuChildrenCountById(Integer id);

    List<String> queryPermissionCodesByUserId(Integer id);
}
