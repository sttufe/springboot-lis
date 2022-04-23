package com.lis.baseModel.controller;


import com.lis.baseModel.entity.DictVs;
import com.lis.baseModel.service.DictVsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 字典对照 前端控制器
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/lis/dict-vs")
public class DictVsController {

    @Autowired
    DictVsService dictvs;

    @RequestMapping("/getAll")
    List<DictVs> getAll (){
        return dictvs.list();
    }

}
