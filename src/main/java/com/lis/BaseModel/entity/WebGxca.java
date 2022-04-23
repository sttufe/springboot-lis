package com.lis.BaseModel.entity;

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
@TableName("web_gxca")
@ApiModel(value = "WebGxca对象", description = "")
public class WebGxca implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("报告ID")
    @TableId("rpt_id")
    private String rptId;

    @ApiModelProperty("签名信息")
    @TableField("sign_value")
    private String signValue;


}
