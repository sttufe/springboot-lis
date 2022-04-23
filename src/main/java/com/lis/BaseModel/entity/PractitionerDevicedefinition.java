package com.lis.BaseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 人员设备
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("practitioner_devicedefinition")
@ApiModel(value = "PractitionerDevicedefinition对象", description = "人员设备")
public class PractitionerDevicedefinition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("practitioner_id")
    private String practitionerId;

    @TableField("devicedefinition_id")
    private String devicedefinitionId;

    @TableField("nightshift_timepoint")
    private String nightshiftTimepoint;

    @TableField("type")
    private String type;


}
