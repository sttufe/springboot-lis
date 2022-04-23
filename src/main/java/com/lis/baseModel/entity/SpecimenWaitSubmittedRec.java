package com.lis.baseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 标本待送检记录
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("specimen_wait_submitted_rec")
@ApiModel(value = "SpecimenWaitSubmittedRec对象", description = "标本待送检记录")
public class SpecimenWaitSubmittedRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("bc_no")
    private String bcNo;

    @TableField("pid")
    private BigDecimal pid;

    @TableField("pat_name")
    private String patName;

    @TableField("organization_id")
    private String organizationId;

    @TableField("location_id")
    private String locationId;

    @TableField("collected_datetime")
    private LocalDateTime collectedDatetime;

    @TableField("specimen_id")
    private Integer specimenId;

    @TableField("procedure_id")
    private Integer procedureId;

    @TableField("receiving_organization_id")
    private String receivingOrganizationId;

    @TableField("receiving_organization_name")
    private String receivingOrganizationName;

    @TableField("receiving_location_id")
    private String receivingLocationId;

    @TableField("receiving_location_name")
    private String receivingLocationName;


}
