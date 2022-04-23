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
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("asynchronousdeliverylist")
@ApiModel(value = "Asynchronousdeliverylist对象", description = "")
public class Asynchronousdeliverylist implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("dataid")
    private String dataid;

    @TableField("currentnum")
    private Integer currentnum;

    @TableField("msg")
    private String msg;

    @TableField("time")
    private LocalDateTime time;

    @TableField("state")
    private String state;


}
