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
 * 系统参数
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("sys_prameter")
@ApiModel(value = "SysPrameter对象", description = "系统参数")
public class SysPrameter implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("参数ID|GUID")
    @TableId("id")
    private String id;

    @ApiModelProperty("参数名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("参数内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("是否启用")
    @TableField("enable")
    private Boolean enable;

    @ApiModelProperty("设置窗体ID")
    @TableField("formid")
    private String formid;

    @ApiModelProperty("最后修改人ID")
    @TableField("lastupdate_practitioner_id")
    private String lastupdatePractitionerId;

    @ApiModelProperty("最后修改人")
    @TableField("lastupdate_practitioner")
    private String lastupdatePractitioner;

    @ApiModelProperty("最后修改时间")
    @TableField("lastupdate_time")
    private Timestamp lastupdateTime;


}
