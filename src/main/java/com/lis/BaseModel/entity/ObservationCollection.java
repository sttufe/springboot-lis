package com.lis.BaseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 检验指标采集定义
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("observation_collection")
@ApiModel(value = "ObservationCollection对象", description = "检验指标采集定义")
public class ObservationCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("observationdefinition_id")
    private String observationdefinitionId;

    @TableField("specimendefinition_id")
    private String specimendefinitionId;

    @TableField("container_id")
    private String containerId;

    @TableField("collection_method_code")
    private String collectionMethodCode;

    @TableField("collection_bodysite_code")
    private String collectionBodysiteCode;

    @TableField("id")
    private String id;


}
