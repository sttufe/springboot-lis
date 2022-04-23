package com.lis.ReportForms.contrller;


import com.alibaba.fastjson.JSONArray;

import com.lis.ReportForms.services.RatePositiveallService;
import com.lis.ReportForms.services.ReportFromServices;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.concurrent.ExecutionException;


@RestController
@RequestMapping("/lis/ReportFrom")
public class ReportFromContrller {

    //Qualifier 当不是spring自动管理的依赖包时 添加注解防止空指针异常
    @Qualifier("reportFromServicesiml")
    @Autowired
    ReportFromServices reportFromServices;

    @Autowired
    RatePositiveallService ratePositiveallService;

    @RequestMapping("/positive")
    //JSONArray   Map<String, ReportFromServicesiml.Output>
    public JSONArray positive() {

        return reportFromServices.AllReportPositiveRate();
    }


    @RequestMapping("/AsyncPositive")
    public JSONArray AsyncPositive(@RequestParam(value = "BeginTimestamp", required = false, defaultValue = "") String BeginTimestamp, @RequestParam(value = "EndTimestamp", required = false, defaultValue = "") String EndTimestamp) throws ExecutionException, InterruptedException, IOException {


        System.out.println(Timestamp.valueOf(EndTimestamp).getClass());
        System.out.println(Timestamp.valueOf(BeginTimestamp).getClass());

         return ratePositiveallService.AsynRatePositiveAll(  Timestamp.valueOf(BeginTimestamp), Timestamp.valueOf(EndTimestamp));
    }



    @RequestMapping("/EncounterAsyncPositive")
    public JSONArray EncounterAsyncPositive(@RequestParam(value = "BeginTimestamp", required = false, defaultValue = "") String BeginTimestamp, @RequestParam(value = "EndTimestamp", required = false, defaultValue = "") String EndTimestamp) throws ExecutionException, InterruptedException, IOException {


        System.out.println(Timestamp.valueOf(EndTimestamp).getClass());
        System.out.println(Timestamp.valueOf(BeginTimestamp).getClass());

        return ratePositiveallService.EncounterAsynReport( Timestamp.valueOf(BeginTimestamp), Timestamp.valueOf(EndTimestamp));
    }
}

