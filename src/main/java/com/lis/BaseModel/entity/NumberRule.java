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
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("number_rule")
@ApiModel(value = "NumberRule对象", description = "")
public class NumberRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("number_rule_id")
    private String numberRuleId;

    @TableField("number_rule_name")
    private String numberRuleName;

    @TableField("number_rule_prefix")
    private String numberRulePrefix;

    @TableField("number_rule_length")
    private Integer numberRuleLength;

    @ApiModelProperty("1-普通；2-军人；3-孕产妇")
    @TableField("patient_type")
    private String patientType;

    @ApiModelProperty("1-急诊；2-非急诊")
    @TableField("visit_type")
    private String visitType;

    @TableField("age_lower_imit")
    private Integer ageLowerImit;

    @TableField("age_high_imit")
    private Integer ageHighImit;

    @TableField("creater")
    private String creater;

    @TableField("creat_time")
    private LocalDateTime creatTime;

    @TableField("call_priority")
    private Integer callPriority;

    @TableField("use_tate")
    private Boolean useTate;


}
