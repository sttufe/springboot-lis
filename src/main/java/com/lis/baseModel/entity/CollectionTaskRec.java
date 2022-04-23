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
 * 标本采集任务记录
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("collection_task_rec")
@ApiModel(value = "CollectionTaskRec对象", description = "标本采集任务记录")
public class CollectionTaskRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("pid")
    private BigDecimal pid;

    @TableField("pat_name")
    private String patName;

    @TableField("organization_id")
    private String organizationId;

    @TableField("location_id")
    private String locationId;

    @TableField("procedure_id")
    private Integer procedureId;

    @TableField("ex_encounter_type")
    private String exEncounterType;

    @TableField("ex_encounter_display")
    private String exEncounterDisplay;

    @TableField("ex_encounter_reference1encounter")
    private String exEncounterReference1encounter;

    @TableField("ex_bed_no")
    private String exBedNo;

    @TableField("timestamp")
    private LocalDateTime timestamp;

    @TableField("ex_inp_ward_id")
    private String exInpWardId;

    @TableField("ex_inp_ward_name")
    private String exInpWardName;

    @TableField("ex_inp_dept_id")
    private String exInpDeptId;

    @TableField("ex_inp_dept_name")
    private String exInpDeptName;

    @TableField("ex_outp_id")
    private String exOutpId;

    @TableField("ex_outp_name")
    private String exOutpName;

    @ApiModelProperty("就诊ID")
    @TableField("ex_encounter_reference1encounterid")
    private BigDecimal exEncounterReference1encounterid;

    @ApiModelProperty("体检团检标识|1-个人体检；2-团检")
    @TableField("ex_eobject")
    private String exEobject;

    @ApiModelProperty("体检任务编码")
    @TableField("ex_etaskno")
    private String exEtaskno;

    @ApiModelProperty("体检任务名称")
    @TableField("ex_etaskname")
    private String exEtaskname;

    @ApiModelProperty("团检单位编码")
    @TableField("ex_egcode")
    private String exEgcode;

    @ApiModelProperty("团检单位名称")
    @TableField("ex_egname")
    private String exEgname;

    @ApiModelProperty("身份证号")
    @TableField("ex_id_card_no")
    private String exIdCardNo;

    @ApiModelProperty("就诊卡号")
    @TableField("ex_visit_card_no")
    private String exVisitCardNo;


}
