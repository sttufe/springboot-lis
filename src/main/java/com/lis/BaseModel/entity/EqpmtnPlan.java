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
 * 检查定时计划内容
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("eqpmtn_plan")
@ApiModel(value = "EqpmtnPlan对象", description = "检查定时计划内容")
public class EqpmtnPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("计划ID")
    @TableId("eqpmtn_plan_id")
    private Long eqpmtnPlanId;

    @ApiModelProperty("关联计划对象ID")
    @TableField("eqp_id")
    private String eqpId;

    @ApiModelProperty("关联计划对象名称")
    @TableField("eqp_name")
    private String eqpName;

    @ApiModelProperty("检查类型GUID")
    @TableField("eqpmtn_type_id")
    private String eqpmtnTypeId;

    @ApiModelProperty("检查周期 : 周，天，月，季，年")
    @TableField("eqpmtn_type_cycle")
    private String eqpmtnTypeCycle;

    @ApiModelProperty("计划名称")
    @TableField("eqpmtn_plan_name")
    private String eqpmtnPlanName;

    @ApiModelProperty("计划类型")
    @TableField("plan_type")
    private String planType;

    @ApiModelProperty("开始时间")
    @TableField("eqpmtn_plan_time_start")
    private Timestamp eqpmtnPlanTimeStart;

    @ApiModelProperty("结束时间")
    @TableField("eqpmtn_plan_time_end")
    private Timestamp eqpmtnPlanTimeEnd;

    @ApiModelProperty("日程地点")
    @TableField("eqpmtn_plan_addr")
    private String eqpmtnPlanAddr;

    @ApiModelProperty("日程描述")
    @TableField("eqpmtn_plan_desc")
    private String eqpmtnPlanDesc;

    @ApiModelProperty("检查记录ID")
    @TableField("eqpmtn_rec_id")
    private Long eqpmtnRecId;

    @ApiModelProperty("处理状态")
    @TableField("proc_status")
    private String procStatus;

    @ApiModelProperty("检查分类名称")
    @TableField("eqpmtn_class_name")
    private String eqpmtnClassName;


}
