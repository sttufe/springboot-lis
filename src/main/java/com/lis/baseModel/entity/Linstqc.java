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
 * 检验仪器质控
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("linstqc")
@ApiModel(value = "Linstqc对象", description = "检验仪器质控")
public class Linstqc implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("json")
    private String json;

    @TableField("status")
    private String status;

    @TableField("timestamp")
    private LocalDateTime timestamp;


}
