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
 * 检验小组人员
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("group_practitioner")
@ApiModel(value = "GroupPractitioner对象", description = "检验小组人员")
public class GroupPractitioner implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("practitioner_id")
    private String practitionerId;

    @TableField("group_id")
    private String groupId;

    @TableField("grpldr")
    private Boolean grpldr;


}
