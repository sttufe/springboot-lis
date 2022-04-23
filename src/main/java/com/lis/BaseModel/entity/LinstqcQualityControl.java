package com.lis.BaseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 室间质控表
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("linstqc_quality_control")
@ApiModel(value = "LinstqcQualityControl对象", description = "室间质控表")
public class LinstqcQualityControl implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("linstqc_roomid")
    private Long linstqcRoomid;

    @ApiModelProperty("仪器名称")
    @TableField("devicename_name")
    private String devicenameName;

    @ApiModelProperty("仪器id")
    @TableField("devicename_id")
    private String devicenameId;

    @ApiModelProperty("质控时间")
    @TableField("linstqc_time")
    private LocalDateTime linstqcTime;

    @ApiModelProperty("截止时间")
    @TableField("end_time")
    private LocalDateTime endTime;

    @ApiModelProperty("标本id")
    @TableField("specim_id")
    private Long specimId;

    @ApiModelProperty("质控类型 1-室间质控，2-对比质控")
    @TableField("linstqc_type")
    private String linstqcType;

    @ApiModelProperty("任务ID")
    @TableField("task_id")
    private Long taskId;

    @ApiModelProperty("{		\"linstqc_roomid\": \"主键ID\",		\"qcno\": \"序号\",		\"deviceName_name\": \"仪器名称\",		\"deviceName_id\": \"仪器ID\",		\"specimen_type\": \"标本类型\",		\"linstqc_time\": \"质控时间\",		\"end_time\": \"截至时间\",		\"outqc_rsn\": \"原因分析\",		\"outqc_dpsms\": \"处理措施\",		\"specim_id\": \"标本ID，对照specime\",		\"registrant\": \"登记人\",		\"registration_time\": \"登记时间\",		\"auditer\": \"审核者\",		\"audit_time\": \"审核时间\",		\"filing_person\": \"归档者\",		\"filing_time\": \"归档时间\",		\"task_id\": \"任务ID\",		\"status\": \"状态\",		\"linstqc_type\": \"质控类型\"	}")
    @TableField("json")
    private String json;

    @ApiModelProperty("状态")
    @TableField("status")
    private String status;

    @ApiModelProperty("次数")
    @TableField("times")
    private Long times;


}
