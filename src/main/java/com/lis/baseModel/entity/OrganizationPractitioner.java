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
 * 组织人员
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("organization_practitioner")
@ApiModel(value = "OrganizationPractitioner对象", description = "组织人员")
public class OrganizationPractitioner implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("organization_id")
    private String organizationId;

    @TableField("practitioner_id")
    private String practitionerId;

    @TableField("id")
    private String id;

    @TableField("timestamp")
    private LocalDateTime timestamp;


}
