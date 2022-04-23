package com.lis.BaseModel.entity;

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
 * 待处理标本记录
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("specimen_wait_proc_rec")
@ApiModel(value = "SpecimenWaitProcRec对象", description = "待处理标本记录")
public class SpecimenWaitProcRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("bc_no")
    private String bcNo;

    @TableField("pid")
    private BigDecimal pid;

    @TableField("pat_name")
    private String patName;

    @TableField("specimen_id")
    private String specimenId;

    @TableField("status")
    private String status;

    @TableField("receiving_datetime")
    private LocalDateTime receivingDatetime;

    @TableField("checkreceive_datetime")
    private LocalDateTime checkreceiveDatetime;

    @TableField("checkreceive_location_id")
    private String checkreceiveLocationId;

    @TableField("checkreceive_organization_id")
    private String checkreceiveOrganizationId;

    @TableField("procedure_id")
    private Integer procedureId;

    @TableField("devicedefinition_id")
    private String devicedefinitionId;

    @TableField("accessionIdentifier_value")
    private String accessionidentifierValue;

    @TableField("ex_reexamination_times")
    private Integer exReexaminationTimes;

    @TableField("spcm_id")
    private Integer spcmId;

    @TableField("ex_encounter_type")
    private String exEncounterType;

    @TableField("ex_encounter_display")
    private String exEncounterDisplay;

    @TableField("ex_encounter_reference1encounter")
    private String exEncounterReference1encounter;

    @TableField("ex_reviewstatus")
    private String exReviewstatus;

    @TableField("ex_valuedo")
    private String exValuedo;

    @ApiModelProperty("保存或修改上级号时需要对此值进行处理，目前仅处理手动核收的标本")
    @TableField("ex_no_mac")
    private String exNoMac;


}
