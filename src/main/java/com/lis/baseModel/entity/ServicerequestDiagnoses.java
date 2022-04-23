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
 * 申请疾病对照
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("servicerequest_diagnoses")
@ApiModel(value = "ServicerequestDiagnoses对象", description = "申请疾病对照")
public class ServicerequestDiagnoses implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("医嘱ID")
    @TableId("order_id")
    private String orderId;

    @ApiModelProperty("检验项目ID")
    @TableField("labitem_id")
    private String labitemId;

    @ApiModelProperty("检验项目编码")
    @TableField("labitem_code")
    private String labitemCode;

    @ApiModelProperty("检验项目")
    @TableField("labitem_name")
    private String labitemName;

    @ApiModelProperty("疾病编码")
    @TableField("diagnosis_code")
    private String diagnosisCode;

    @ApiModelProperty("疾病名称")
    @TableField("diagnosis_name")
    private String diagnosisName;

    @ApiModelProperty("创建时间")
    @TableField("creat_time")
    private LocalDateTime creatTime;

    @ApiModelProperty("ID")
    @TableField("id")
    private Integer id;

    @ApiModelProperty("状态|active-有效;inactive-无效")
    @TableField("status")
    private String status;


}
