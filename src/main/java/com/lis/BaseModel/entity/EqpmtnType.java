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
 * 设备检查规则
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("eqpmtn_type")
@ApiModel(value = "EqpmtnType对象", description = "设备检查规则")
public class EqpmtnType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("检查类型GUID")
    @TableId("eqpmtn_type_id")
    private String eqpmtnTypeId;

    @ApiModelProperty("检查分类")
    @TableField("eqpmtn_class_code")
    private String eqpmtnClassCode;

    @ApiModelProperty("检查分类名称")
    @TableField("eqpmtn_class_name")
    private String eqpmtnClassName;

    @ApiModelProperty("设备ID")
    @TableField("devicedefinition_id")
    private String devicedefinitionId;

    @ApiModelProperty("设备名称")
    @TableField("devicedefinition_name")
    private String devicedefinitionName;

    @ApiModelProperty("检查周期")
    @TableField("eqpmtn_type_cycle")
    private String eqpmtnTypeCycle;

    @ApiModelProperty("设备检查时间")
    @TableField("eqpmtn_type_time")
    private String eqpmtnTypeTime;

    @ApiModelProperty("检查时间")
    @TableField("eqpmtn_type_time_1")
    private String eqpmtnTypeTime1;

    @ApiModelProperty("最后修改人GUID")
    @TableField("last_modifier_id")
    private String lastModifierId;

    @ApiModelProperty("最后修改人")
    @TableField("last_modifie")
    private String lastModifie;

    @ApiModelProperty("所属业务域")
    @TableField("eqp_domain")
    private String eqpDomain;

    @ApiModelProperty("使用状态")
    @TableField("use_sign")
    private String useSign;

    @ApiModelProperty("最后更新时间")
    @TableField("last_updatetime")
    private Timestamp lastUpdatetime;


}
