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
 * 检验申请记录
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("servicerequest_rec")
@ApiModel(value = "ServicerequestRec对象", description = "检验申请记录")
public class ServicerequestRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("pid")
    private BigDecimal pid;

    @TableField("pat_name")
    private String patName;

    @TableField("encounter")
    private String encounter;

    @TableField("encounter_servicetype")
    private String encounterServicetype;

    @TableField("servicerequest_code")
    private String servicerequestCode;

    @TableField("servicerequest_authoredon")
    private LocalDateTime servicerequestAuthoredon;

    @TableField("pat_infctdz_sign")
    private String patInfctdzSign;

    @TableField("priority")
    private String priority;

    @TableField("status")
    private String status;

    @TableField("requisition_value")
    private String requisitionValue;

    @TableField("servicerequest_organization")
    private String servicerequestOrganization;

    @TableField("procedure_id")
    private Integer procedureId;

    @TableField("ex_condition_code")
    private String exConditionCode;

    @TableField("ex_condition_display")
    private String exConditionDisplay;

    @TableField("basedOn_reference")
    private String basedonReference;

    @TableField("ex_source_system")
    private String exSourceSystem;

    @ApiModelProperty("体检团检标识|1-个人体检；2-团检")
    @TableField("ex_eobject")
    private String exEobject;

    @ApiModelProperty("团检单位编码")
    @TableField("ex_egcode")
    private String exEgcode;

    @ApiModelProperty("团检单位名称")
    @TableField("ex_egname")
    private String exEgname;

    @ApiModelProperty("体检任务编码")
    @TableField("ex_etaskno")
    private String exEtaskno;

    @ApiModelProperty("体检任务名称")
    @TableField("ex_etaskname")
    private String exEtaskname;

    @ApiModelProperty("身份证号")
    @TableField("ex_id_card_no")
    private String exIdCardNo;

    @ApiModelProperty("就诊卡号")
    @TableField("ex_visit_card_no")
    private String exVisitCardNo;

    @TableField("calculation_num")
    private Integer calculationNum;

    @ApiModelProperty("患者身份编码")
    @TableField("unitcode")
    private String unitcode;

    @ApiModelProperty("患者身份名称")
    @TableField("unitname")
    private String unitname;


}
