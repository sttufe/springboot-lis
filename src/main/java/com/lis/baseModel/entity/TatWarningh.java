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
 * TAT预警数据已处理数据表
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("tat_warningh")
@ApiModel(value = "TatWarningh对象", description = "TAT预警数据已处理数据表")
public class TatWarningh implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @ApiModelProperty("标本ID")
    @TableField("spcm_id")
    private Integer spcmId;

    @ApiModelProperty("环节编码和TAT编码相同")
    @TableField("type_code")
    private Integer typeCode;

    @ApiModelProperty("数据产生时间")
    @TableField("timestamp")
    private LocalDateTime timestamp;

    @ApiModelProperty("设置的TAT时间")
    @TableField("tat_time")
    private Integer tatTime;

    @ApiModelProperty("操作人ID")
    @TableField("performer_id")
    private String performerId;

    @ApiModelProperty("操作人姓名")
    @TableField("performer_name")
    private String performerName;

    @ApiModelProperty("操作人科室ID")
    @TableField("performer_organizetion_id")
    private String performerOrganizetionId;

    @ApiModelProperty("操作人科室名称")
    @TableField("performer_organizetion_name")
    private String performerOrganizetionName;

    @ApiModelProperty("操作人地点ID")
    @TableField("performer_location_id")
    private String performerLocationId;

    @ApiModelProperty("操作人地点名称")
    @TableField("performer_location_name")
    private String performerLocationName;

    @ApiModelProperty("1=此记录已经产生了消息，避免重复计算")
    @TableField("calculate")
    private Integer calculate;


}
