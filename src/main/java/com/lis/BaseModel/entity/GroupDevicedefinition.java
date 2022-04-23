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
 * 小组设备
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("group_devicedefinition")
@ApiModel(value = "GroupDevicedefinition对象", description = "小组设备")
public class GroupDevicedefinition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("group_id")
    private String groupId;

    @TableField("devicedefinition_id")
    private String devicedefinitionId;

    @TableField("nightshift_timepoint")
    private String nightshiftTimepoint;


}
