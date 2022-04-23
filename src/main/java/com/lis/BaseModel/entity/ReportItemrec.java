package com.lis.BaseModel.entity;

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
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("report_itemrec")
@ApiModel(value = "ReportItemrec对象", description = "")
public class ReportItemrec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("reportid")
    private String reportid;

    @TableField("reportname")
    private String reportname;

    @TableField("itemid")
    private String itemid;

    @TableField("itemname")
    private String itemname;

    @TableField("id")
    private Integer id;

    @ApiModelProperty("补充条件")
    @TableField("ex_condition")
    private String exCondition;


}
