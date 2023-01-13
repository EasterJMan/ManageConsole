package com.jzy.erpboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.jzy.erpboot.system.mapper","com.jzy.erpboot.business.mapper"})
public class ErpbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErpbootApplication.class, args);
    }

}
