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
 * 采集账单对照
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("collect_invoice")
@ApiModel(value = "CollectInvoice对象", description = "采集账单对照")
public class CollectInvoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("账单ID")
    @TableId("invoice_id")
    private Integer invoiceId;

    @ApiModelProperty("采集任务ID")
    @TableField("collect_task_id")
    private Integer collectTaskId;

    @ApiModelProperty("容器业务ID")
    @TableField("container_id")
    private Integer containerId;

    @ApiModelProperty("容器字典ID")
    @TableField("container_dict_id")
    private String containerDictId;

    @ApiModelProperty("标本条码号")
    @TableField("specimen_bc")
    private String specimenBc;

    @ApiModelProperty("采集方法编码")
    @TableField("collect_method_code")
    private String collectMethodCode;

    @ApiModelProperty("采集方法")
    @TableField("collect_method_name")
    private String collectMethodName;

    @ApiModelProperty("采集部位编码")
    @TableField("collect_bodysite_code")
    private String collectBodysiteCode;

    @ApiModelProperty("采集部位")
    @TableField("collect_bodysite_name")
    private String collectBodysiteName;

    @ApiModelProperty("采集时机编码")
    @TableField("collect_ocas_code")
    private String collectOcasCode;

    @ApiModelProperty("采集时机")
    @TableField("collect_ocas_name")
    private String collectOcasName;

    @ApiModelProperty("标本字典ID")
    @TableField("specimen_id")
    private String specimenId;

    @ApiModelProperty("标本字典名称")
    @TableField("specimen_name")
    private String specimenName;

    @ApiModelProperty("急项")
    @TableField("is_urgent")
    private Boolean isUrgent;


}
