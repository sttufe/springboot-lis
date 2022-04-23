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
 * 检验仪器质控项目
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("linstqcitem")
@ApiModel(value = "Linstqcitem对象", description = "检验仪器质控项目")
public class Linstqcitem implements Serializable {

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

    @TableField("devicedefinition_id")
    private String devicedefinitionId;

    @TableField("qcmatid")
    private String qcmatid;


}
