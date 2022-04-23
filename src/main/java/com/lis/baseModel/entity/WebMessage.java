package com.lis.baseModel.entity;

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
 * 消息记录表
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("web_message")
@ApiModel(value = "WebMessage对象", description = "消息记录表")
public class WebMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @ApiModelProperty("标本ID")
    @TableField("spcm_id")
    private Integer spcmId;

    @ApiModelProperty("消息类型，界面会根据此字段分组")
    @TableField("msg_type")
    private String msgType;

    @ApiModelProperty("消息明细")
    @TableField("msg_info")
    private String msgInfo;

    @ApiModelProperty("目标提醒人ID")
    @TableField("performer_id")
    private String performerId;

    @ApiModelProperty("目标提醒人姓名")
    @TableField("performer_name")
    private String performerName;

    @ApiModelProperty("目标提醒科室ID")
    @TableField("performer_organizetion_id")
    private String performerOrganizetionId;

    @ApiModelProperty("目标提醒科室名称")
    @TableField("performer_organizetion_name")
    private String performerOrganizetionName;

    @ApiModelProperty("目标提醒小组ID")
    @TableField("group_id")
    private String groupId;

    @ApiModelProperty("目标提醒小组名称")
    @TableField("group_name")
    private String groupName;

    @ApiModelProperty("预留其他关键字。TAT消息存放的tat_warning.id")
    @TableField("other_key")
    private String otherKey;

    @ApiModelProperty("消息产生时间")
    @TableField("timestamp")
    private LocalDateTime timestamp;


}
