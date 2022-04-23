package com.lis.BaseModel.entity;

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
@TableName("linstqc_rec")
@ApiModel(value = "LinstqcRec对象", description = "")
public class LinstqcRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("dept_id")
    private String deptId;

    @TableField("rgnt_id")
    private String rgntId;

    @TableField("qcmat_id")
    private String qcmatId;

    @TableField("qcmat_level_type")
    private String qcmatLevelType;

    @TableField("labistrmt_id")
    private String labistrmtId;

    @TableField("lspcm_dtmtd_id")
    private String lspcmDtmtdId;

    @TableField("linstqc_time")
    private LocalDateTime linstqcTime;

    @TableField("status")
    private String status;

    @TableField("linstqc_recoder_id")
    private String linstqcRecoderId;

    @TableField("specimen_id")
    private Integer specimenId;


}
