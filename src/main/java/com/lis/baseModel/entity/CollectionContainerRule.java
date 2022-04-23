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
 * 采集合试管规则
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("collection_container_rule")
@ApiModel(value = "CollectionContainerRule对象", description = "采集合试管规则")
public class CollectionContainerRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("code")
    private String code;

    @TableField("name")
    private String name;

    @TableField("description")
    private String description;

    @TableField("status")
    private String status;


}
