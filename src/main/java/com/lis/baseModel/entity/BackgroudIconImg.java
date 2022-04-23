package com.lis.baseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 背景图标图形表
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("backgroud_icon_img")
@ApiModel(value = "BackgroudIconImg对象", description = "背景图标图形表")
public class BackgroudIconImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("图形id")
    @TableId("id")
    private String id;

    @ApiModelProperty("背景图")
    @TableField("backgroud_img")
    private String backgroudImg;

    @ApiModelProperty("图标")
    @TableField("icon_img")
    private String iconImg;

    @ApiModelProperty("医院名称")
    @TableField("hospital_name")
    private String hospitalName;

    @ApiModelProperty("自助机倒计时")
    @TableField("self_countdown")
    private Integer selfCountdown;


}
