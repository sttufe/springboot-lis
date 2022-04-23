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
@TableName("taskstart")
@ApiModel(value = "Taskstart对象", description = "")
public class Taskstart implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("msgid")
    private String msgid;

    @TableField("taskid")
    private String taskid;

    @TableField("taskname")
    private String taskname;

    @TableField("nodetime")
    private LocalDateTime nodetime;

    @TableField("flowname")
    private String flowname;

    @TableField("flowid")
    private String flowid;

    @TableField("paramstr")
    private String paramstr;


}
