package com.lis.baseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 设备指标
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("devicedefinition_observationdefinition")
@ApiModel(value = "DevicedefinitionObservationdefinition对象", description = "设备指标")
public class DevicedefinitionObservationdefinition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("observationdefinition_id")
    private String observationdefinitionId;

    @TableField("devicedefinition_id")
    private String devicedefinitionId;

    @TableField("pipline_code")
    private String piplineCode;

    @TableField("taking_time")
    private Integer takingTime;

    @TableField("observationdefinition_cost")
    private String observationdefinitionCost;

    @TableField("ex_Conversion_ratio")
    private String exConversionRatio;

    @TableField("ex_Result_transformation")
    private String exResultTransformation;

    @TableField("ex_default_results")
    private String exDefaultResults;

    @TableField("ex_qccode")
    private Boolean exQccode;

    @TableField("sno")
    private Integer sno;

    @ApiModelProperty("单通道码多指标默认")
    @TableField("ex_oneChooseCode")
    private Boolean exOnechoosecode;


}
