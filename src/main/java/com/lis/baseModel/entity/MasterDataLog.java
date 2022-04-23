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
 * 主数据日志
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("master_data_log")
@ApiModel(value = "MasterDataLog对象", description = "主数据日志")
public class MasterDataLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("master_id")
    private String masterId;

    @TableField("type")
    private String type;

    @TableField("json")
    private String json;

    @TableField("operator_id")
    private String operatorId;

    @TableField("timestamp")
    private LocalDateTime timestamp;

    @TableField("id")
    private String id;

    @TableField("modify_mode")
    private String modifyMode;


}
