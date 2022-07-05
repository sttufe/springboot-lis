package com.lis.reportSevice.services;


import org.springframework.stereotype.Component;

@Component
public interface ReportService {

    String Get_HepatitisB(String b_data,String e_data);

    String GetPositiveOfPCR(String b_data,String e_data);

}
