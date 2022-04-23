package com.lis.BaseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.sql.Timestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 检验指标测量值记录
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("observation_rec")
@ApiModel(value = "ObservationRec对象", description = "检验指标测量值记录")
public class ObservationRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    @TableField("procedure_id")
    private Integer procedureId;

    @TableField("specimen_id")
    private String specimenId;

    @TableField("devicedefinition_id")
    private String devicedefinitionId;

    @TableField("observationdefinition_id")
    private String observationdefinitionId;

    @TableField("specimen_reference1Specimen")
    private Integer specimenReference1specimen;

    @TableField("status")
    private String status;

    @TableField("issued_datetime")
    private Timestamp issuedDatetime;

    @TableField("ex_reexamination")
    private Integer exReexamination;

    @TableField("ex_valuedo")
    private String exValuedo;

    @TableField("ex_merge_sign")
    private String exMergeSign;

    @ApiModelProperty("合并指标记录ID")
    @TableField("merge_id")
    private String mergeId;


}
