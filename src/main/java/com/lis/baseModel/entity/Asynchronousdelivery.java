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
@TableName("asynchronousdelivery")
@ApiModel(value = "Asynchronousdelivery对象", description = "")
public class Asynchronousdelivery implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("dataid")
    private String dataid;

    @TableField("msgid")
    private String msgid;

    @TableField("msgidentifier")
    private String msgidentifier;

    @TableField("maxnum")
    private Integer maxnum;

    @TableField("currentnum")
    private Integer currentnum;

    @TableField("intervaltime")
    private Integer intervaltime;

    @TableField("paramjson")
    private String paramjson;

    @TableField("nodesetting")
    private String nodesetting;

    @TableField("time")
    private LocalDateTime time;

    @TableField("state")
    private String state;


}
