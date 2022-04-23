package com.lis.BaseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
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
@TableName("tat_log_rec")
@ApiModel(value = "TatLogRec对象", description = "")
public class TatLogRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("tat_id")
    private String tatId;

    @TableField("servicerequest_id")
    private Integer servicerequestId;

    @TableField("specimen_id")
    private Integer specimenId;

    @TableField("dispose_measure_code")
    private String disposeMeasureCode;

    @TableField("specimen_bc_no")
    private String specimenBcNo;

    @TableField("status")
    private String status;

    @TableField("parent_specimen_id")
    private Integer parentSpecimenId;

    @TableField("pid")
    private BigDecimal pid;

    @TableField("pat_name")
    private String patName;

    @TableField("labitem_id")
    private String labitemId;


}
