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
@TableName("numbe_use_rule")
@ApiModel(value = "NumbeUseRule对象", description = "")
public class NumbeUseRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("number_use_rule_id")
    private String numberUseRuleId;

    @TableField("call_office_set_id")
    private String callOfficeSetId;

    @TableField("number_rule_id")
    private String numberRuleId;

    @TableField("use_name_rule_name")
    private String useNameRuleName;

    @TableField("max_num")
    private Integer maxNum;

    @TableField("last_getcl_time")
    private LocalDateTime lastGetclTime;


}
