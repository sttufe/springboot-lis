package com.lis.baseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 行政区
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("region")
@ApiModel(value = "Region对象", description = "行政区")
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("code")
    private String code;

    @TableField("name")
    private String name;

    @TableField("level")
    private Integer level;


}
