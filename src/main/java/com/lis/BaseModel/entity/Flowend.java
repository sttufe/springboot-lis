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
@TableName("flowend")
@ApiModel(value = "Flowend对象", description = "")
public class Flowend implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("msgid")
    private String msgid;

    @TableField("nodetime")
    private Timestamp nodetime;

    @TableField("starttime")
    private Timestamp starttime;

    @TableField("state")
    private String state;

    @TableField("runtime")
    private Double runtime;

    @TableField("feedback")
    private String feedback;


}
