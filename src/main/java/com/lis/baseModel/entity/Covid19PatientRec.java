package com.lis.baseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@TableName("COVID19_Patient_rec")
@ApiModel(value = "Covid19PatientRec对象", description = "")
public class Covid19PatientRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("患者ID")
    @TableId("id")
    private String id;

    @ApiModelProperty("姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("性别")
    @TableField("sex")
    private String sex;

    @ApiModelProperty("年龄")
    @TableField("age")
    private String age;

    @ApiModelProperty("身份证")
    @TableField("idCard")
    private String idCard;

    @ApiModelProperty("手机号")
    @TableField("phoneNumber")
    private String phoneNumber;

    @ApiModelProperty("标本ID")
    @TableField("spcm_id")
    private Integer spcmId;

    @ApiModelProperty("报告ID")
    @TableField("rpt_id")
    private Integer rptId;

    @ApiModelProperty("患者信息")
    @TableField("pat_info")
    private String patInfo;

    @ApiModelProperty("核收时间")
    @TableField("chkrcv_time")
    private LocalDateTime chkrcvTime;

    @ApiModelProperty("报告时间")
    @TableField("rpt_time")
    private LocalDateTime rptTime;

    @ApiModelProperty("标本条码")
    @TableField("spcm_bc")
    private String spcmBc;


}
