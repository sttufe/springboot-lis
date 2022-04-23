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
 * 设备检查项目列表
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("eqpmtn_item")
@ApiModel(value = "EqpmtnItem对象", description = "设备检查项目列表")
public class EqpmtnItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("检查项目GUID")
    @TableId("eqpmtn_item_id")
    private String eqpmtnItemId;

    @ApiModelProperty("项目名称")
    @TableField("eqpmtn_item_name")
    private String eqpmtnItemName;

    @ApiModelProperty("检查类型GUID")
    @TableField("eqpmtn_type_id")
    private String eqpmtnTypeId;

    @ApiModelProperty("序号")
    @TableField("eqpmtn_item_sno")
    private String eqpmtnItemSno;

    @ApiModelProperty("要素类型")
    @TableField("eqpmtn_item_datatype_code")
    private String eqpmtnItemDatatypeCode;

    @ApiModelProperty("要素类型名称")
    @TableField("eqpmtn_item_datatype_name")
    private String eqpmtnItemDatatypeName;

    @ApiModelProperty("是否必填")
    @TableField("eqpmtn_item_nullable_sign")
    private Boolean eqpmtnItemNullableSign;

    @ApiModelProperty("默认值")
    @TableField("eqpmtn_item_default")
    private String eqpmtnItemDefault;

    @ApiModelProperty("选项值")
    @TableField("eqpmtn_item_optn")
    private String eqpmtnItemOptn;

    @ApiModelProperty("对应规范")
    @TableField("eqpmtn_item_stdrd")
    private String eqpmtnItemStdrd;

    @ApiModelProperty("最后修改人GUID")
    @TableField("last_modifier_id")
    private String lastModifierId;

    @ApiModelProperty("最后修改人")
    @TableField("last_modifier")
    private String lastModifier;

    @ApiModelProperty("最后修改时间")
    @TableField("last_updatetime")
    private Timestamp lastUpdatetime;

    @ApiModelProperty("使用状态")
    @TableField("use_sign")
    private String useSign;

    @ApiModelProperty("选项集合")
    @TableField("eqpmtn_item_optn_1")
    private String eqpmtnItemOptn1;

    @ApiModelProperty("选项默认值")
    @TableField("eqpmtn_item_default_1")
    private String eqpmtnItemDefault1;


}
