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
@TableName("print_rec")
@ApiModel(value = "PrintRec对象", description = "")
public class PrintRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("business_type_code")
    private String businessTypeCode;

    @TableField("business_type_display")
    private String businessTypeDisplay;

    @TableField("business_id")
    private String businessId;

    @TableField("business_bc")
    private String businessBc;

    @TableField("practitioner_id")
    private String practitionerId;

    @TableField("practitioner_name")
    private String practitionerName;

    @TableField("organization_id")
    private String organizationId;

    @TableField("organization_name")
    private String organizationName;

    @TableField("location_id")
    private String locationId;

    @TableField("location_name")
    private String locationName;

    @TableField("device_id")
    private String deviceId;

    @TableField("device_name")
    private String deviceName;

    @TableField("print_time")
    private LocalDateTime printTime;


}
