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
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("equipment_bad_rec")
@ApiModel(value = "EquipmentBadRec对象", description = "")
public class EquipmentBadRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @ApiModelProperty("设备ID")
    @TableField("equipment_id")
    private String equipmentId;

    @ApiModelProperty("上报人ID")
    @TableField("reporter")
    private String reporter;

    @ApiModelProperty("不良事件发生事件")
    @TableField("bad_happen_date")
    private Timestamp badHappenDate;

    @ApiModelProperty("不良事件知悉事件")
    @TableField("bad_know_date")
    private Timestamp badKnowDate;

    @ApiModelProperty("事件表现")
    @TableField("bad_event")
    private String badEvent;

    @ApiModelProperty("事件后果")
    @TableField("consequence")
    private String consequence;

    @ApiModelProperty("事件陈述")
    @TableField("event_state")
    private String eventState;

    @ApiModelProperty("事件操作人ID")
    @TableField("operationer")
    private String operationer;

    @ApiModelProperty("事件原因分析")
    @TableField("reason_analysis")
    private String reasonAnalysis;

    @ApiModelProperty("事件通知情况")
    @TableField("notice")
    private String notice;


}
