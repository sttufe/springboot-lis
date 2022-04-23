package com.lis.BaseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 部门人员同步
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("dept_staff_synchronize")
@ApiModel(value = "DeptStaffSynchronize对象", description = "部门人员同步")
public class DeptStaffSynchronize implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId("id")
    private String id;

    @ApiModelProperty("资源类型|部门;人员")
    @TableField("type")
    private String type;

    @ApiModelProperty("资源操作类型|新增;修改;启用;停用")
    @TableField("code")
    private String code;

    @ApiModelProperty("HIS_ID")
    @TableField("his_id")
    private String hisId;

    @ApiModelProperty("资源ID")
    @TableField("map_id")
    private String mapId;

    @ApiModelProperty("名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("状态|wait-未同步;done-已同步")
    @TableField("state")
    private String state;

    @ApiModelProperty("记录时间")
    @TableField("timestamp")
    private LocalDateTime timestamp;

    @ApiModelProperty("最后同步时间")
    @TableField("last_syntime")
    private LocalDateTime lastSyntime;

    @ApiModelProperty("同步错误日志")
    @TableField("err_log")
    private String errLog;


}
