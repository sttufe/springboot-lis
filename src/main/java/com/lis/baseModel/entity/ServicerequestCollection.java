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
 * 申请采集关系
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("servicerequest_collection")
@ApiModel(value = "ServicerequestCollection对象", description = "申请采集关系")
public class ServicerequestCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("servicerequest_id")
    private Integer servicerequestId;

    @TableField("collection_id")
    private Integer collectionId;

    @TableField("status")
    private String status;

    @TableField("id")
    private Integer id;

    @TableField("task_json")
    private String taskJson;


}
