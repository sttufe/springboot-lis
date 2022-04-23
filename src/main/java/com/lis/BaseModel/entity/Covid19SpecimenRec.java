package com.lis.BaseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("COVID19_Specimen_Rec")
@ApiModel(value = "Covid19SpecimenRec对象", description = "")
public class Covid19SpecimenRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("临生免标本ID")
    @TableId("lis_spcm_id")
    private Integer lisSpcmId;

    @ApiModelProperty("临生免报告ID")
    @TableField("lis_rpt_id")
    private Integer lisRptId;

    @ApiModelProperty("标本id")
    @TableField("id")
    private BigDecimal id;

    @ApiModelProperty("组合条码号")
    @TableField("combinedSpecimenNumber")
    private String combinedSpecimenNumber;

    @ApiModelProperty("标本条码号")
    @TableField("specimenNumber")
    private String specimenNumber;

    @ApiModelProperty("采集时间")
    @TableField("collectionTime")
    private String collectionTime;

    @ApiModelProperty("采集人")
    @TableField("collector")
    private String collector;

    @ApiModelProperty("采集终端mac地址")
    @TableField("macAddress")
    private String macAddress;

    @ApiModelProperty("采集终端描述")
    @TableField("terminalNote")
    private String terminalNote;

    @ApiModelProperty("送检人")
    @TableField("makesPeople")
    private String makesPeople;

    @ApiModelProperty("送检时间")
    @TableField("makesTime")
    private String makesTime;

    @ApiModelProperty("送检医疗机构编码")
    @TableField("makesOrganizationCode")
    private String makesOrganizationCode;

    @ApiModelProperty("送检医疗机构名称")
    @TableField("makesOrganizationName")
    private String makesOrganizationName;

    @ApiModelProperty("核收人")
    @TableField("acceptanceCheck")
    private String acceptanceCheck;

    @ApiModelProperty("核收时间")
    @TableField("acceptanceCheckTime")
    private String acceptanceCheckTime;

    @ApiModelProperty("院内标本id")
    @TableField("nosocomialSpecimenID")
    private String nosocomialSpecimenID;

    @ApiModelProperty("报告人")
    @TableField("reporter")
    private String reporter;

    @ApiModelProperty("报告时间")
    @TableField("reportOnTime")
    private String reportOnTime;

    @ApiModelProperty("标本状态")
    @TableField("specimenState")
    private String specimenState;

    @ApiModelProperty("居民信息")
    @TableField("residentInfos")
    private String residentInfos;


}
