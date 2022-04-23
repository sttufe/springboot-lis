package com.lis.BaseModel.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/lis/asynchronousdelivery")
public class AsynchronousdeliveryController {

    @RequestMapping("/test")
    String test(){


        int a=100;
        int b=33;
        double f1 = new BigDecimal((float)b/a).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        return f1*100+"%";
    }

}
