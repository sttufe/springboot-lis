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
 * 组织位置
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("organization_location")
@ApiModel(value = "OrganizationLocation对象", description = "组织位置")
public class OrganizationLocation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("organization_id")
    private String organizationId;

    @TableField("location_id")
    private String locationId;

    @TableField("timestamp")
    private LocalDateTime timestamp;


}
