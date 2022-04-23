package com.lis.baseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@TableName("web_parameters")
@ApiModel(value = "WebParameters对象", description = "")
public class WebParameters implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("para_name")
    private String paraName;

    @ApiModelProperty("0=全局参数，1=本机参数，2=私有参数")
    @TableField("para_type")
    private Integer paraType;

    @TableField("para_info")
    private String paraInfo;


}
