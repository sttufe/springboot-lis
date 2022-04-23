package com.lis.baseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.sql.Timestamp;

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
@TableName("equipment_check_rec")
@ApiModel(value = "EquipmentCheckRec对象", description = "")
public class EquipmentCheckRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @ApiModelProperty("设备ID")
    @TableField("equipment_id")
    private String equipmentId;

    @ApiModelProperty("验收部门ID")
    @TableField("organization_id")
    private String organizationId;

    @ApiModelProperty("验收数量")
    @TableField("check_num")
    private Integer checkNum;

    @ApiModelProperty("验收情况")
    @TableField("check_situation")
    private String checkSituation;

    @ApiModelProperty("验收结论")
    @TableField("check_conclusion")
    private String checkConclusion;

    @ApiModelProperty("验收时间")
    @TableField("check_time")
    private Timestamp checkTime;

    @ApiModelProperty("验收人")
    @TableField("cherker")
    private String cherker;


}
