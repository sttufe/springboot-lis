package com.lis.BaseModel.entity;

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
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("intfc_log")
@ApiModel(value = "IntfcLog对象", description = "")
public class IntfcLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("parent_id")
    private Integer parentId;

    @TableField("business")
    private String business;

    @TableField("source")
    private String source;

    @TableField("direction")
    private String direction;

    @TableField("target")
    private String target;

    @TableField("result")
    private Integer result;

    @TableField("err_log")
    private String errLog;

    @TableField("timestamp")
    private Timestamp timestamp;

    @TableField("status")
    private String status;

    @TableField("duration")
    private String duration;

    @TableField("parameter")
    private String parameter;

    @TableField("system")
    private String system;


}
