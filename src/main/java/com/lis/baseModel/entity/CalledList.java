package com.lis.baseModel.entity;

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
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("called_list")
@ApiModel(value = "CalledList对象", description = "")
public class CalledList implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("called_list_id")
    private Long calledListId;

    @TableField("patient_id")
    private Long patientId;

    @TableField("patient_name")
    private String patientName;

    @TableField("patient_age")
    private String patientAge;

    @TableField("treatment_number")
    private String treatmentNumber;

    @ApiModelProperty("1-门诊；2-住院；3-体检")
    @TableField("treatment_source")
    private Integer treatmentSource;

    @TableField("id_number")
    private String idNumber;

    @TableField("medical_insurance_card")
    private String medicalInsuranceCard;

    @TableField("one_card")
    private String oneCard;

    @TableField("call_office_id")
    private String callOfficeId;

    @TableField("call_office_name")
    private String callOfficeName;

    @ApiModelProperty("0-正在叫号;1-叫号完成；2-号码过号")
    @TableField("call_state")
    private Integer callState;

    @ApiModelProperty("1-可用；2-作废")
    @TableField("number_state")
    private Integer numberState;

    @ApiModelProperty("1-已采集；2-未采集")
    @TableField("acquisition_status")
    private Integer acquisitionStatus;

    @TableField("sequence_number")
    private String sequenceNumber;

    @TableField("call_window_id")
    private String callWindowId;

    @TableField("call_window_name")
    private String callWindowName;

    @TableField("callers")
    private String callers;

    @TableField("get_time")
    private LocalDateTime getTime;

    @TableField("call_number")
    private Integer callNumber;

    @TableField("call_priority")
    private Integer callPriority;


}
