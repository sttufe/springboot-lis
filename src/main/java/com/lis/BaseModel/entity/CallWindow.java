package com.lis.BaseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@TableName("call_window")
@ApiModel(value = "CallWindow对象", description = "")
public class CallWindow implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("call_window_id")
    private String callWindowId;

    @TableField("call_office_set_id")
    private String callOfficeSetId;

    @TableField("call_window_name")
    private String callWindowName;

    @TableField("window_ip")
    private String windowIp;

    @ApiModelProperty("1-采血窗口；2-非采血窗口")
    @TableField("window_nature")
    private Boolean windowNature;

    @TableField("display_address")
    private String displayAddress;

    @TableField("remarks")
    private String remarks;

    @TableField("is_stop")
    private Boolean isStop;


}
