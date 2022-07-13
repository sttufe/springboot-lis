package com.lis.reportSevice.contrller;

import com.lis.reportSevice.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


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
                                 @RequestParam(value = "e_data", required = false, defaultValue = "") String e_data,
                                 @RequestParam(value = "SQLCondition", required = false, defaultValue = "") String SQLCondition,
                                 @RequestParam(value = "quest_data", required = false, defaultValue = "") String quest_data,
                                 @RequestParam(value = "condition", required = false, defaultValue = "") String condition)
    {
        return reportService.Get_HepatitisB(b_data,e_data,SQLCondition, quest_data,condition);
    }

    /**
     * PCR传染病
     * @param b_data
     * @param e_data
     * @return
     */
    @RequestMapping("/GetPositiveOfPCR")
    public String GetPositiveOfPCR(@RequestParam(value = "b_data", defaultValue = "") String b_data,
                                   @RequestParam(value = "e_data", defaultValue = "") String e_data,
                                   @RequestParam(value = "SQLCondition") String SQLCondition,
                                   @RequestParam(value = "quest_data", required = false, defaultValue = "") String quest_data,

                                   @RequestParam(value = "condition", required = false) String condition) throws IOException {

        return reportService.GetPositiveOfPCR(b_data,e_data,SQLCondition,quest_data,condition);
    }


    /**
     * 艾乙梅
     * condition 为SQL 条件 and 开头 没有 默认为空
     * @param b_data
     * @param e_data
     * @param condition
     * @return
     */
    @RequestMapping("/GetObstetricsItem")
    public String GetObstetricsItem(@RequestParam(value = "b_data", required = false, defaultValue = "") String b_data,
                                    @RequestParam(value = "e_data", required = false, defaultValue = "") String e_data,
                                    @RequestParam(value = "SQLCondition") String SQLCondition,
                                    @RequestParam(value = "quest_data") String quest_data,
                                    @RequestParam(value = "condition", required = false) String condition) throws IOException {

        return reportService.GetObstetricsItem(b_data,e_data,SQLCondition,quest_data,condition);
    }


    /**
     * 免疫组传染病
     * @param b_data
     * @param e_data
     * @param SQLCondition
     * @param condition
     * @return
     * @throws IOException
     */
    @RequestMapping("/getInfectiousDiseases")
    public String getInfectiousDiseases(@RequestParam(value = "b_data", required = false, defaultValue = "") String b_data,
                                        @RequestParam(value = "e_data", required = false, defaultValue = "") String e_data,
                                        @RequestParam(value = "SQLCondition") String SQLCondition,
                                        @RequestParam(value = "condition", required = false) String condition,
                                        @RequestParam(value = "quest_data", required = false) String quest_data,
                                        @RequestParam(value = "observationItems", required = false) String observationItems) throws IOException {

        return reportService.getInfectiousDiseases(b_data,e_data,SQLCondition,condition,quest_data,observationItems);
    }
}
