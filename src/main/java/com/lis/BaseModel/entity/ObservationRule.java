package com.lis.BaseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 指标规则计算
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("observation_rule")
@ApiModel(value = "ObservationRule对象", description = "指标规则计算")
public class ObservationRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("ruleid")
    private String ruleid;

    @TableField("ruletype")
    private String ruletype;

    @TableField("judging")
    private String judging;

    @TableField("observation_name")
    private String observationName;

    @TableField("observation_id")
    private String observationId;

    @TableField("conditiontype")
    private String conditiontype;

    @TableField("conditionresult")
    private String conditionresult;

    @TableField("conditionvalus")
    private String conditionvalus;

    @TableField("status")
    private String status;

    @TableField("rulename")
    private String rulename;

    @TableField("observationset_id")
    private String observationsetId;

    @TableField("observationset_name")
    private String observationsetName;

    @TableField("note_text")
    private String noteText;


}
