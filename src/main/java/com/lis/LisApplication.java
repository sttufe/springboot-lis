package com.lis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan(value = {"com.lis.reportSevice.mapper","com.lis.api.mapper",
        "com.lis.baseModel.mapper",})
@SpringBootApplication
public class LisApplication {

    public static void main(String[] args) {
        SpringApplication.run(LisApplication.class, args);
    }

}
