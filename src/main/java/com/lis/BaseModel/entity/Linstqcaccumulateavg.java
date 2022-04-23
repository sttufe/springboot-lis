package com.lis.BaseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 累积均值质控记录
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("linstqcaccumulateavg")
@ApiModel(value = "Linstqcaccumulateavg对象", description = "累积均值质控记录")
public class Linstqcaccumulateavg implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId("id")
    private Integer id;

    @ApiModelProperty("sd")
    @TableField("sd")
    private BigDecimal sd;

    @ApiModelProperty("avg")
    @TableField("avg")
    private BigDecimal avg;

    @ApiModelProperty("cv")
    @TableField("cv")
    private BigDecimal cv;

    @ApiModelProperty("时间")
    @TableField("time")
    private LocalDateTime time;

    @ApiModelProperty("状态")
    @TableField("status")
    private String status;

    @ApiModelProperty("开始时间")
    @TableField("begtime")
    private LocalDateTime begtime;

    @ApiModelProperty("结束时间")
    @TableField("endtime")
    private LocalDateTime endtime;

    @ApiModelProperty("质控项目ID")
    @TableField("linstqc_item_id")
    private String linstqcItemId;

    @ApiModelProperty("操作者")
    @TableField("ave_modifier")
    private String aveModifier;

    @ApiModelProperty("操作者ID")
    @TableField("ave_modifier_id")
    private String aveModifierId;


}
