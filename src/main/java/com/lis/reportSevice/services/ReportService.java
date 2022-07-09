package com.lis.reportSevice.services;


import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface ReportService {

    String Get_HepatitisB(String b_data,String e_data ,String SQLCondition,String quest_data,String condition);

    String GetPositiveOfPCR(String b_data,String e_data,String SQLCondition,String quest_data,String condition) throws IOException;

    String GetObstetricsItem(String b_data, String e_data,String SQLCondition,String quest_data,String condition) throws IOException;

    //免疫传染病
    String getInfectiousDiseases(String b_data, String e_data,String SQLCondition,String condition,String quest_data) throws IOException;
}
