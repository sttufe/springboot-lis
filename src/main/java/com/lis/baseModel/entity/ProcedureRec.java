package com.lis.baseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 操作记录
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("procedure_rec")
@ApiModel(value = "ProcedureRec对象", description = "操作记录")
public class ProcedureRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("pid")
    private BigDecimal pid;

    @TableField("pat_name")
    private String patName;

    @TableField("code_coding_code")
    private String codeCodingCode;

    @TableField("organization_id")
    private String organizationId;

    @TableField("actor_id")
    private String actorId;

    @TableField("status")
    private String status;

    @TableField("location_id")
    private String locationId;

    @TableField("performedDateTime")
    private LocalDateTime performedDateTime;

    @TableField("source_id")
    private Integer sourceId;

    @TableField("partOf_reference1Procedure")
    private Integer partofReference1procedure;

    @TableField("source_table")
    private String sourceTable;

    @TableField("ex_encounter_type")
    private String exEncounterType;

    @TableField("ex_encounter_display")
    private String exEncounterDisplay;

    @TableField("ex_encounter_reference1encounter")
    private String exEncounterReference1encounter;

    @TableField("ex_bed_no")
    private String exBedNo;

    @ApiModelProperty("身份证号")
    @TableField("ex_id_card_no")
    private String exIdCardNo;

    @ApiModelProperty("就诊卡号")
    @TableField("ex_visit_card_no")
    private String exVisitCardNo;


}
