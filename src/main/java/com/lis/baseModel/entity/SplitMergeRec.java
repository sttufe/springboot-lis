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
 * 拆分合并记录
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("split_merge_rec")
@ApiModel(value = "SplitMergeRec对象", description = "拆分合并记录")
public class SplitMergeRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("type")
    private String type;

    @TableField("split_merge_time")
    private LocalDateTime splitMergeTime;

    @TableField("organization_id")
    private String organizationId;

    @TableField("location_id")
    private String locationId;

    @TableField("practitioner_id")
    private String practitionerId;

    @TableField("status")
    private String status;

    @TableField("parent_id")
    private Integer parentId;


}
