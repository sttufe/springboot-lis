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
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("devicedefinition_snorule")
@ApiModel(value = "DevicedefinitionSnorule对象", description = "")
public class DevicedefinitionSnorule implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("devicedefinition_id")
    private String devicedefinitionId;

    @TableField("devicedefinition_name")
    private String devicedefinitionName;

    @TableField("sno_low")
    private String snoLow;

    @TableField("sno_hight")
    private String snoHight;

    @TableField("id")
    private String id;

    @TableField("today_sno")
    private String todaySno;

    @TableField("linstqc_sign")
    private Boolean linstqcSign;

    @TableField("labitem")
    private String labitem;


}
