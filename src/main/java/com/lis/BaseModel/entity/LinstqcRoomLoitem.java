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
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("linstqc_room_loitem")
@ApiModel(value = "LinstqcRoomLoitem对象", description = "")
public class LinstqcRoomLoitem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    @ApiModelProperty("指标ID")
    @TableField("loteim_id")
    private String loteimId;

    @ApiModelProperty("指标业务ID")
    @TableField("obsid")
    private Long obsid;

    @ApiModelProperty("{		\"id\": \"id\",		\"no\": \"序号\",		\"value\": \"结果值\",		\"loteim_name\": \"指标名称\",		\"loteim_id\": \"指标ID\",		\"nuit\": \"单位\",		\"status\": \"状态\",		\"obsid\": \"指标业务ID\",		\"loitem_time\": \"产生时间\",		\"linstqc_roomid\": \"质控记录ID\"	}")
    @TableField("json")
    private String json;

    @ApiModelProperty("状态")
    @TableField("status")
    private String status;

    @ApiModelProperty("产生时间")
    @TableField("loitem_time")
    private LocalDateTime loitemTime;

    @ApiModelProperty("质控记录ID")
    @TableField("linstqc_roomid")
    private Long linstqcRoomid;


}
