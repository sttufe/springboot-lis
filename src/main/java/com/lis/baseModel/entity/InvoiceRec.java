package com.lis.baseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.sql.Timestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 账单记录
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("invoice_rec")
@ApiModel(value = "InvoiceRec对象", description = "账单记录")
public class InvoiceRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("账单ID")
    @TableId("id")
    private Integer id;

    @ApiModelProperty("患者ID")
    @TableField("pid")
    private Integer pid;

    @ApiModelProperty("患者姓名")
    @TableField("pat_name")
    private String patName;

    @ApiModelProperty("账单时间")
    @TableField("invoice_date")
    private Timestamp invoiceDate;

    @ApiModelProperty("账单号")
    @TableField("invoice_no")
    private String invoiceNo;

    @ApiModelProperty("状态")
    @TableField("status")
    private String status;

    @ApiModelProperty("就诊号")
    @TableField("encounter_no")
    private String encounterNo;

    @ApiModelProperty("就诊关联类型")
    @TableField("encounter_display")
    private String encounterDisplay;

    @ApiModelProperty("就诊关联类型编码")
    @TableField("encounter_type")
    private String encounterType;

    @ApiModelProperty("就诊ID:门诊-挂号单号|住院-主页ID")
    @TableField("encounter_id")
    private String encounterId;

    @ApiModelProperty("开单科室ID")
    @TableField("invoice_organization_id")
    private String invoiceOrganizationId;

    @ApiModelProperty("开单科室")
    @TableField("invoice_organization_name")
    private String invoiceOrganizationName;

    @ApiModelProperty("开单人ID")
    @TableField("invoice_actor_id")
    private String invoiceActorId;

    @ApiModelProperty("开单人")
    @TableField("invoice_actor_name")
    private String invoiceActorName;


}
