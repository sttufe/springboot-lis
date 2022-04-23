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
 * 仪器质控指标
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("linstqc_loitem")
@ApiModel(value = "LinstqcLoitem对象", description = "仪器质控指标")
public class LinstqcLoitem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("linstqc_loitem_id")
    private Integer linstqcLoitemId;

    @TableField("linstqc_id")
    private Integer linstqcId;

    @TableField("loitem_status")
    private String loitemStatus;

    @TableField("loitem_id")
    private String loitemId;

    @TableField("linstqc_item_id")
    private String linstqcItemId;

    @TableField("rgnt_id")
    private String rgntId;

    @TableField("timestamp")
    private LocalDateTime timestamp;

    @TableField("item_times")
    private Integer itemTimes;


}
