package com.lis.BaseModel.entity;

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
@TableName("observation_plan")
@ApiModel(value = "ObservationPlan对象", description = "")
public class ObservationPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("name")
    private String name;

    @TableField("observations")
    private String observations;

    @TableField("devices")
    private String devices;

    @TableField("practitioner_id")
    private String practitionerId;

    @TableField("practitioner_name")
    private String practitionerName;

    @TableField("timestamp")
    private LocalDateTime timestamp;

    @TableField("status")
    private String status;


}
