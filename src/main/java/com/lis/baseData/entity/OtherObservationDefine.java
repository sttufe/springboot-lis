package com.lis.baseData.entity;


import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OtherObservationDefine {

    private String 项目代码;
    private String  项目名称;
    private String  细菌标识;
    private String    项目归类;
    private String  仪器大类;
    private String      英文缩写;
    private String  英文名称;
    private String     结果类型;
    private String 默认文字结果标志;
    private String     单位;
    private String   小数位数;
    private String      参考下限;
    private String 检验指标_csv;
    private String     参考上限;
    private String 参考范围;
    private String   打印代码;

}
