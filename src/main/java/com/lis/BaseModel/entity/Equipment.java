package com.lis.BaseModel.entity;

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
 * 设备表
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("equipment")
@ApiModel(value = "Equipment对象", description = "设备表")
public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("设备ID")
    @TableId("equipment_id")
    private String equipmentId;

    @ApiModelProperty("设备名称")
    @TableField("equipment_name")
    private String equipmentName;

    @ApiModelProperty("设备类型")
    @TableField("equipment_type")
    private String equipmentType;

    @ApiModelProperty("设备生厂商ID")
    @TableField("eprentp_id")
    private String eprentpId;

    @ApiModelProperty("设备使用状态：启用：active|禁用：Disable|报废：scrap|维修：overhaul")
    @TableField("equipment_status")
    private String equipmentStatus;

    @ApiModelProperty("设备生产时间")
    @TableField("equipment_production_time")
    private Timestamp equipmentProductionTime;

    @ApiModelProperty("设备使用年限")
    @TableField("equipment_life")
    private Integer equipmentLife;

    @ApiModelProperty("设备报废时间")
    @TableField("equipment_scrap_time")
    private Timestamp equipmentScrapTime;

    @ApiModelProperty("建档人")
    @TableField("equipment_filinger")
    private String equipmentFilinger;

    @ApiModelProperty("建档时间")
    @TableField("equipment_filing_time")
    private Timestamp equipmentFilingTime;

    @ApiModelProperty("备注")
    @TableField("equipment_remarks")
    private String equipmentRemarks;

    @ApiModelProperty("报废原因")
    @TableField("equipment_scrap_reason")
    private String equipmentScrapReason;

    @ApiModelProperty("机构ID")
    @TableField("organization_id")
    private String organizationId;

    @ApiModelProperty("最后修改时间")
    @TableField("last_modification_time")
    private Timestamp lastModificationTime;

    @ApiModelProperty("设备ip")
    @TableField("eqp_ip")
    private String eqpIp;

    @ApiModelProperty("地点")
    @TableField("address")
    private String address;

    @ApiModelProperty("最后修改人")
    @TableField("last_modificationer")
    private String lastModificationer;

    @ApiModelProperty("模块内容")
    @TableField("modes_info")
    private String modesInfo;


}
