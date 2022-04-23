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
 * 检验报告记录
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("diagnosticreport_rec")
@ApiModel(value = "DiagnosticreportRec对象", description = "检验报告记录")
public class DiagnosticreportRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("pid")
    private BigDecimal pid;

    @TableField("pat_name")
    private String patName;

    @TableField("status")
    private String status;

    @TableField("procedure_id")
    private Integer procedureId;

    @TableField("issued")
    private LocalDateTime issued;

    @TableField("type")
    private String type;

    @TableField("group_id")
    private String groupId;

    @TableField("specmids")
    private String specmids;

    @TableField("uniqueid")
    private String uniqueid;

    @ApiModelProperty("身份证号")
    @TableField("ex_id_card_no")
    private String exIdCardNo;

    @ApiModelProperty("就诊卡号")
    @TableField("ex_visit_card_no")
    private String exVisitCardNo;


}
