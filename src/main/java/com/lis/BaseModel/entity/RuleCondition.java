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
 * 规则条件
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("rule_condition")
@ApiModel(value = "RuleCondition对象", description = "规则条件")
public class RuleCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("json")
    private String json;

    @TableField("timestamp")
    private LocalDateTime timestamp;

    @TableField("name")
    private String name;

    @TableField("rule_id")
    private String ruleId;

    @TableField("rule_type_code")
    private String ruleTypeCode;

    @TableField("status")
    private String status;

    @TableField("rule_priority")
    private Integer rulePriority;


}
