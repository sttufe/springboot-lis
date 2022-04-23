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
 * 人员
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("practitioner")
@ApiModel(value = "Practitioner对象", description = "人员")
public class Practitioner implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("name")
    private String name;

    @TableField("json")
    private String json;

    @TableField("status")
    private String status;

    @TableField("timestamp")
    private LocalDateTime timestamp;

    @TableField("no")
    private String no;

    @TableField("useridcardnum")
    private String useridcardnum;


}
