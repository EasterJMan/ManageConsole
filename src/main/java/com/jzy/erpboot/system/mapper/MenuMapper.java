package com.jzy.erpboot.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzy.erpboot.system.domain.Menu;

public interface MenuMapper extends BaseMapper<Menu> {
    Integer queryMenuMaxOrderNum();

    Integer queryMenuChildrenCountById(Integer id);
}