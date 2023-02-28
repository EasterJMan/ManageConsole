package com.jzy.erpboot;

import com.jzy.erpboot.system.domain.Menu;
import com.jzy.erpboot.system.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MenuInitUtils {

    @Autowired
    private MenuService menuService;

    @Test
    void contextLoads() {
//        menuService.save(new Menu(1,0,"topmenu","business","系统管理","fa fa-home","","",0,1,1));
    }

}
