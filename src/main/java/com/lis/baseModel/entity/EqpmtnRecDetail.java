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
 * 设备检查记录明细
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("eqpmtn_rec_detail")
@ApiModel(value = "EqpmtnRecDetail对象", description = "设备检查记录明细")
public class EqpmtnRecDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("检查记录明细ID")
    @TableId("eqpmtn_rec_detail_id")
    private Long eqpmtnRecDetailId;

    @ApiModelProperty("检查记录ID")
    @TableField("eqpmtn_rec_id")
    private Long eqpmtnRecId;

    @ApiModelProperty("检查项目GUID")
    @TableField("eqpmtn_item_id")
    private String eqpmtnItemId;

    @ApiModelProperty("项目名称")
    @TableField("eqpmtn_item_name")
    private String eqpmtnItemName;

    @ApiModelProperty("检查项目值")
    @TableField("eqpmtn_item_value")
    private String eqpmtnItemValue;

    @ApiModelProperty("检查项值_调查问卷")
    @TableField("eqpmtn_item_value_1")
    private String eqpmtnItemValue1;


}
