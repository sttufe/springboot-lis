package com.lis.baseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 状态记录
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("condition_rec")
@ApiModel(value = "ConditionRec对象", description = "状态记录")
public class ConditionRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("recordeddate")
    private LocalDateTime recordeddate;

    @TableField("code_coding_code")
    private String codeCodingCode;

    @TableField("verificationstatus_coding_code")
    private String verificationstatusCodingCode;

    @TableField("pid")
    private BigDecimal pid;

    @TableField("pat_name")
    private String patName;

    @TableField("status")
    private String status;

    @TableField("problem_sign")
    private Boolean problemSign;

    @TableField("diagnosis_sign")
    private Boolean diagnosisSign;

    @TableField("ex_specimen_id")
    private String exSpecimenId;

    @TableField("recorder_organization_id")
    private String recorderOrganizationId;

    @ApiModelProperty("就诊类型编码")
    @TableField("ex_encounter_type")
    private String exEncounterType;

    @ApiModelProperty("就诊类型")
    @TableField("ex_encounter_display")
    private String exEncounterDisplay;

    @ApiModelProperty("就诊号")
    @TableField("ex_encounter_no")
    private String exEncounterNo;

    @ApiModelProperty("患者科室ID")
    @TableField("ex_pat_dept_id")
    private String exPatDeptId;

    @ApiModelProperty("患者科室")
    @TableField("ex_pat_dept_name")
    private String exPatDeptName;

    @ApiModelProperty("患者病区ID")
    @TableField("ex_inp_ward_id")
    private String exInpWardId;

    @ApiModelProperty("患者病区")
    @TableField("ex_inp_ward_name")
    private String exInpWardName;

    @ApiModelProperty("床号")
    @TableField("ex_bed_no")
    private String exBedNo;


}
