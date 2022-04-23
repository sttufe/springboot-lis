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
@TableName("service_period")
@ApiModel(value = "ServicePeriod对象", description = "")
public class ServicePeriod implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("service_period_id")
    private String servicePeriodId;

    @TableField("call_office_set_id")
    private String callOfficeSetId;

    @TableField("time_interval")
    private String timeInterval;

    @TableField("start_time")
    private String startTime;

    @TableField("end_time")
    private String endTime;


}
