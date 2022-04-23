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
 * 设备检查记录
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("eqpmtn_rec")
@ApiModel(value = "EqpmtnRec对象", description = "设备检查记录")
public class EqpmtnRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("检查记录ID")
    @TableId("eqpmtn_rec_id")
    private Long eqpmtnRecId;

    @ApiModelProperty("设备guid")
    @TableField("eqp_id")
    private String eqpId;

    @ApiModelProperty("设备名称")
    @TableField("eqp_name")
    private String eqpName;

    @ApiModelProperty("检查类型GUID")
    @TableField("eqpmtn_type_id")
    private String eqpmtnTypeId;

    @ApiModelProperty("检查周期")
    @TableField("eqpmtn_type_cycle")
    private String eqpmtnTypeCycle;

    @ApiModelProperty("任务日期")
    @TableField("eqpmtn_plan_time")
    private String eqpmtnPlanTime;

    @ApiModelProperty("实际检查时间")
    @TableField("eqpmtn_rec_exetime")
    private Timestamp eqpmtnRecExetime;

    @ApiModelProperty("部门ID")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty("部门名称")
    @TableField("dept_name")
    private String deptName;

    @ApiModelProperty("检查者GUID")
    @TableField("eqpmtn_rec_exetr_id")
    private String eqpmtnRecExetrId;

    @ApiModelProperty("检查者")
    @TableField("eqpmtn_rec_exetr")
    private String eqpmtnRecExetr;

    @ApiModelProperty("摘要说明")
    @TableField("eqpmtn_rec_desc")
    private String eqpmtnRecDesc;

    @ApiModelProperty("录入者GUID")
    @TableField("eqpmtn_rec_creator_id")
    private String eqpmtnRecCreatorId;

    @ApiModelProperty("录入者")
    @TableField("eqpmtn_rec_creator")
    private String eqpmtnRecCreator;

    @ApiModelProperty("录入时间")
    @TableField("eqpmtn_rec_create_time")
    private String eqpmtnRecCreateTime;

    @ApiModelProperty("所属业务域")
    @TableField("eqp_domain")
    private String eqpDomain;


}
