package com.lis.baseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
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
@TableName("request_labitem_plan")
@ApiModel(value = "RequestLabitemPlan对象", description = "")
public class RequestLabitemPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("plan_id")
    private String planId;

    @TableField("plan_name")
    private String planName;

    @TableField("plan_content")
    private String planContent;

    @TableField("practitioner_id")
    private String practitionerId;

    @TableField("practitioner_name")
    private String practitionerName;

    @TableField("timestamp")
    private LocalDateTime timestamp;


}
