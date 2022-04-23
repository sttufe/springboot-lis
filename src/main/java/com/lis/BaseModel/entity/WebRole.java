package com.lis.BaseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 网页角色表
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("web_role")
@ApiModel(value = "WebRole对象", description = "网页角色表")
public class WebRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("role_id")
    private String roleId;

    @TableField("name")
    private String name;

    @TableField("json")
    private String json;

    @TableField("enable")
    private Boolean enable;


}
