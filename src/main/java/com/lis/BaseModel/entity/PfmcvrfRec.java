package com.lis.BaseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 性能验证记录
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("pfmcvrf_rec")
@ApiModel(value = "PfmcvrfRec对象", description = "性能验证记录")
public class PfmcvrfRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @ApiModelProperty("性能验证类型")
    @TableField("pfmcvrf_type")
    private String pfmcvrfType;

    @ApiModelProperty("性能验证方式")
    @TableField("pfmcvrf_mode")
    private String pfmcvrfMode;

    @ApiModelProperty("性能验证时间")
    @TableField("pfmcvrf_oper_time")
    private LocalDateTime pfmcvrfOperTime;

    @ApiModelProperty("性能验证人ID")
    @TableField("pfmcvrf_oprtr_id")
    private String pfmcvrfOprtrId;

    @ApiModelProperty("性能验证状态")
    @TableField("status")
    private String status;

    @ApiModelProperty("检验设备ID")
    @TableField("labistrmt_id")
    private String labistrmtId;

    @ApiModelProperty("标本检验方法ID")
    @TableField("lspcm_dtmtd_id")
    private String lspcmDtmtdId;

    @ApiModelProperty("试剂ID")
    @TableField("rgnt_id")
    private String rgntId;

    @ApiModelProperty("质控品ID")
    @TableField("qcmat_id")
    private String qcmatId;


}
