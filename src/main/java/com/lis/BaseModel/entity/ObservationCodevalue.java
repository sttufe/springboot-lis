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
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("observation_codevalue")
@ApiModel(value = "ObservationCodevalue对象", description = "")
public class ObservationCodevalue implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("his_id")
    private String hisId;

    @TableField("chs_name")
    private String chsName;

    @TableField("code")
    private String code;

    @TableField("code_value")
    private String codeValue;

    @TableField("default_value")
    private String defaultValue;


}
