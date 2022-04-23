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
@TableName("web_user_parameters")
@ApiModel(value = "WebUserParameters对象", description = "")
public class WebUserParameters implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("para_id")
    private String paraId;

    @ApiModelProperty("当web_parameters.para_type=1时，存放mac地址，=2时存放人员ID")
    @TableField("identify_str")
    private String identifyStr;

    @ApiModelProperty("{		para_value,			//参数值	}")
    @TableField("user_para_info")
    private String userParaInfo;


}
