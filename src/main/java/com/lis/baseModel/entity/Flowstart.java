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
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("flowstart")
@ApiModel(value = "Flowstart对象", description = "")
public class Flowstart implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("msgid")
    private String msgid;

    @TableField("pmsgid")
    private String pmsgid;

    @TableField("taskid")
    private String taskid;

    @TableField("taskname")
    private String taskname;

    @TableField("flowname")
    private String flowname;

    @TableField("flowid")
    private String flowid;

    @TableField("nodetime")
    private Timestamp nodetime;

    @TableField("paramstr")
    private String paramstr;


}
