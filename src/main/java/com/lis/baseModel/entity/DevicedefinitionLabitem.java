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
 * 设备检验项目
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("devicedefinition_labitem")
@ApiModel(value = "DevicedefinitionLabitem对象", description = "设备检验项目")
public class DevicedefinitionLabitem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("devicedefinition_id")
    private String devicedefinitionId;

    @TableField("lab_item_code")
    private String labItemCode;


}
