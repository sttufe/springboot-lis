package com.lis.BaseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 检验项目
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("lab_item")
@ApiModel(value = "LabItem对象", description = "检验项目")
public class LabItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("code")
    private String code;

    @TableField("name")
    private String name;

    @TableField("category")
    private String category;

    @TableField("description")
    private String description;

    @TableField("status")
    private String status;

    @TableField("timestamp")
    private LocalDateTime timestamp;

    @TableField("hisid")
    private String hisid;

    @TableField("ex_hideItem")
    private Boolean exHideitem;

    @ApiModelProperty("英文缩写")
    @TableField("ex_abbreviation_display")
    private String exAbbreviationDisplay;

    @ApiModelProperty("启用英文缩写")
    @TableField("ex_abbreviation_enable")
    private Boolean exAbbreviationEnable;


}
