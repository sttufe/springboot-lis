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
 * 自助机项目对照
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("selfservice_items_rec")
@ApiModel(value = "SelfserviceItemsRec对象", description = "自助机项目对照")
public class SelfserviceItemsRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("对照guid")
    @TableId("id")
    private String id;

    @ApiModelProperty("自助机id")
    @TableField("self_eqp_id")
    private String selfEqpId;

    @ApiModelProperty("自助机名称")
    @TableField("self_eqp_name")
    private String selfEqpName;

    @ApiModelProperty("指定项目id")
    @TableField("item_id")
    private String itemId;

    @ApiModelProperty("指定项目名称")
    @TableField("item_name")
    private String itemName;


}
