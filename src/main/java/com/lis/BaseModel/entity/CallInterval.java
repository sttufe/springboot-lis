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
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("call_interval")
@ApiModel(value = "CallInterval对象", description = "")
public class CallInterval implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("call_interval_id")
    private Integer callIntervalId;

    @TableField("call_project_id")
    private String callProjectId;

    @TableField("call_order")
    private Integer callOrder;

    @TableField("order_number")
    private Integer orderNumber;

    @TableField("order_company")
    private String orderCompany;


}
