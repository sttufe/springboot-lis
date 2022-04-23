package com.lis.baseData.controller;

import com.lis.baseData.service.ImObserDefineOtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/basedata")
public class ImpWithOtherController {

    @Autowired
    ImObserDefineOtherService imObserDefineOtherService;


    @RequestMapping("/impobsDefine")
    public String ImpObservationDefinetion(){
        imObserDefineOtherService.funImport();
        return "apifox";
    }
}
