package com.lis.baseModel.controller;


import com.lis.baseModel.entity.SysPrameter;
import com.lis.baseModel.service.SysPrameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 系统参数 前端控制器
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/lis/sys-prameter")
public class SysPrameterController {

    @Autowired
    SysPrameterService sysPrameterService;

    @RequestMapping("/getAll")
    List<SysPrameter> getAll(){
        return sysPrameterService.list();
    }

}
