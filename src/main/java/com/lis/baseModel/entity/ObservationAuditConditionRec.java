package com.lis.baseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("observation_audit_condition_rec")
@ApiModel(value = "ObservationAuditConditionRec对象", description = "")
public class ObservationAuditConditionRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("code_text")
    private String codeText;

    @TableField("name")
    private String name;

    @TableField("classification")
    private String classification;

    @TableField("item_id")
    private String itemId;

    @TableField("linstq_id")
    private String linstqId;


}
