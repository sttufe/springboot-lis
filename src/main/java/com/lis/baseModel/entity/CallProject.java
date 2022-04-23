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
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("call_project")
@ApiModel(value = "CallProject对象", description = "")
public class CallProject implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("call_project_id")
    private Integer callProjectId;

    @TableField("call_project_name")
    private String callProjectName;

    @TableField("call_number")
    private Integer callNumber;


}
