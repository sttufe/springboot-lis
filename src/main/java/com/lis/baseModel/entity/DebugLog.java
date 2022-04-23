package com.lis.baseModel.entity;

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
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("debug_log")
@ApiModel(value = "DebugLog对象", description = "")
public class DebugLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId("id")
    private Integer id;

    @ApiModelProperty("业务类型")
    @TableField("business")
    private String business;

    @ApiModelProperty("业务ID")
    @TableField("business_id")
    private String businessId;

    @ApiModelProperty("业务号码")
    @TableField("business_bc")
    private String businessBc;

    @ApiModelProperty("日志内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("时间戳")
    @TableField("timestamp")
    private LocalDateTime timestamp;


}
