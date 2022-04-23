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
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("practitioner_power")
@ApiModel(value = "PractitionerPower对象", description = "")
public class PractitionerPower implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("practitioner_id")
    private String practitionerId;

    @TableField("power_code")
    private String powerCode;

    @TableField("timestamp")
    private LocalDateTime timestamp;

    @TableField("power_name")
    private String powerName;


}
