package com.lis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@MapperScan(value = {"com.lis.BaseModel.mapper","com.lis.ReportForms.mapper","com.lis.API.mapper"})
@SpringBootApplication
public class LisApplication {

    public static void main(String[] args) {
        SpringApplication.run(LisApplication.class, args);
    }

}
