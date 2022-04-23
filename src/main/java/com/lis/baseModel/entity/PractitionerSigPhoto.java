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
@TableName("practitioner_sig_photo")
@ApiModel(value = "PractitionerSigPhoto对象", description = "")
public class PractitionerSigPhoto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("人员ID")
    @TableId("practitioner_id")
    private String practitionerId;

    @ApiModelProperty("人员名称")
    @TableField("practitioner_name")
    private String practitionerName;

    @ApiModelProperty("人员签名图片")
    @TableField("sig_photo")
    private byte[] sigPhoto;


}
