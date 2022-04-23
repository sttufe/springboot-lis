package com.lis.baseModel.entity;

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
@TableName("linstqc_qcmat")
@ApiModel(value = "LinstqcQcmat对象", description = "")
public class LinstqcQcmat implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("qcmat_id")
    private String qcmatId;

    @TableField("qcmat_name")
    private String qcmatName;

    @TableField("leve_type_name")
    private String leveTypeName;

    @TableField("level_type")
    private String levelType;

    @TableField("qcmat_no")
    private String qcmatNo;

    @TableField("qcmat_time")
    private LocalDateTime qcmatTime;

    @TableField("qcmat_begtime")
    private LocalDateTime qcmatBegtime;

    @TableField("labistrmt_id")
    private String labistrmtId;

    @TableField("rgnt_info")
    private String rgntInfo;

    @TableField("calibrator_info")
    private String calibratorInfo;

    @TableField("status")
    private String status;

    @TableField("labistrmt_name")
    private String labistrmtName;

    @TableField("unionqcmat")
    private String unionqcmat;

    @TableField("unionqcmatname")
    private String unionqcmatname;

    @TableField("accessionidentifier_value")
    private String accessionidentifierValue;

    @TableField("draw_color")
    private String drawColor;


}
