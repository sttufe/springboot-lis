package com.lis.BaseModel.entity;

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
@TableName("linstqcitemavg_rec")
@ApiModel(value = "LinstqcitemavgRec对象", description = "")
public class LinstqcitemavgRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("linstqc_item_avg_id")
    private Integer linstqcItemAvgId;

    @TableField("labistrmt_id")
    private String labistrmtId;

    @TableField("linstqc_item_id")
    private String linstqcItemId;

    @TableField("linstqc_item_loitem_id")
    private String linstqcItemLoitemId;

    @TableField("linstqc_item_level_type")
    private String linstqcItemLevelType;

    @TableField("linstqc_item_avg_status")
    private String linstqcItemAvgStatus;

    @TableField("linstqc_item_avg_time")
    private LocalDateTime linstqcItemAvgTime;


}
