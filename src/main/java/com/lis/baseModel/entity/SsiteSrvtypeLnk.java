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
 * 服务点关系
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("ssite_srvtype_lnk")
@ApiModel(value = "SsiteSrvtypeLnk对象", description = "服务点关系")
public class SsiteSrvtypeLnk implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("organization_id")
    private String organizationId;

    @TableField("parent_organization_id")
    private String parentOrganizationId;

    @TableField("parent_id")
    private String parentId;


}
