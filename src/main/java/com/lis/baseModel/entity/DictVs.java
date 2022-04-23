package com.lis.baseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.sql.Timestamp;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 字典对照
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("dict_vs")
@ApiModel(value = "DictVs对象", description = "字典对照")
public class DictVs implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("type")
    private String type;

    @TableField("source_system")
    private String sourceSystem;

    @TableField("source_id")
    private String sourceId;

    @TableField("source_code")
    private String sourceCode;

    @TableField("source_name")
    private String sourceName;

    @TableField("target_id")
    private String targetId;

    @TableField("target_code")
    private String targetCode;

    @TableField("target_name")
    private String targetName;

    @TableField("last_modifier_id")
    private String lastModifierId;

    @TableField("last_modifier")
    private String lastModifier;

    @TableField("last_updatetime")
    private Timestamp lastUpdatetime;


}
