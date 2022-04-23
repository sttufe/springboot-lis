package com.lis.baseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 标本采集记录
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("specimen_rec")
@ApiModel(value = "SpecimenRec对象", description = "标本采集记录")
public class SpecimenRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("identifier_value1bc")
    private String identifierValue1bc;

    @TableField("pid")
    private BigDecimal pid;

    @TableField("pat_name")
    private String patName;

    @TableField("specimen_id")
    private String specimenId;

    @TableField("status")
    private String status;

    @TableField("infctdz_sign")
    private String infctdzSign;

    @TableField("priority")
    private String priority;

    @TableField("condition_code")
    private String conditionCode;

    @TableField("collection_id")
    private Integer collectionId;

    @TableField("procedure_id")
    private Integer procedureId;

    @TableField("splitstatus")
    private String splitstatus;

    @TableField("split_value1bc")
    private String splitValue1bc;

    @TableField("encounter_type_code")
    private String encounterTypeCode;

    @TableField("encounter_type")
    private String encounterType;

    @TableField("encounter_no")
    private String encounterNo;

    @TableField("uniqueid")
    private String uniqueid;

    @ApiModelProperty("体检团检标识|1-个人体检；2-团检")
    @TableField("ex_eobject")
    private String exEobject;

    @ApiModelProperty("团检单位编码")
    @TableField("ex_egcode")
    private String exEgcode;

    @ApiModelProperty("团检单位名称")
    @TableField("ex_egname")
    private String exEgname;

    @ApiModelProperty("体检任务编码")
    @TableField("ex_etaskno")
    private String exEtaskno;

    @ApiModelProperty("体检任务名称")
    @TableField("ex_etaskname")
    private String exEtaskname;

    @ApiModelProperty("身份证号")
    @TableField("ex_id_card_no")
    private String exIdCardNo;

    @ApiModelProperty("就诊卡号")
    @TableField("ex_visit_card_no")
    private String exVisitCardNo;

    @ApiModelProperty("双向标识")
    @TableField("duplex_identification")
    private String duplexIdentification;

    @ApiModelProperty("患者身份编码")
    @TableField("unitcode")
    private String unitcode;

    @ApiModelProperty("患者身份名称")
    @TableField("unitname")
    private String unitname;


}
