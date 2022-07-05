package com.lis.reportSevice.contrller;

import com.lis.reportSevice.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/report")
public class ReportContrller {

    @Autowired
    ReportService reportService;

    /**
     * 免疫所有
     * @param b_data
     * @param e_data
     * @return
     */
    @RequestMapping("/getHepatitisB")
    public String Get_HepatitisB(@RequestParam(value = "b_data", required = false, defaultValue = "") String b_data,
                                 @RequestParam(value = "e_data", required = false, defaultValue = "") String e_data)
    {

        return reportService.Get_HepatitisB(b_data,e_data);
    }

    /**
     * PCR传染病
     * @param b_data
     * @param e_data
     * @return
     */
    @RequestMapping("/GetPositiveOfPCR")
    public String GetPositiveOfPCR(@RequestParam(value = "b_data", required = false, defaultValue = "") String b_data,
                                  @RequestParam(value = "e_data", required = false, defaultValue = "") String e_data)
    {

        return reportService.GetPositiveOfPCR(b_data,e_data);
    }

}
