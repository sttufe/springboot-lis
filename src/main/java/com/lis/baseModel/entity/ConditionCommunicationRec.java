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
 * 状态待通知记录
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("condition_communication_rec")
@ApiModel(value = "ConditionCommunicationRec对象", description = "状态待通知记录")
public class ConditionCommunicationRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("recordedDate")
    private LocalDateTime recordedDate;

    @TableField("pid")
    private BigDecimal pid;

    @TableField("pat_name")
    private String patName;

    @TableField("category")
    private String category;

    @TableField("specimen_name")
    private String specimenName;

    @TableField("recorder_organization_id")
    private String recorderOrganizationId;

    @TableField("specimen_id")
    private Integer specimenId;

    @TableField("order_id")
    private String orderId;

    @TableField("servicerequest_id")
    private Integer servicerequestId;

    @TableField("ex_revoke")
    private Boolean exRevoke;

    @TableField("basedOn_reference")
    private Integer basedonReference;

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
