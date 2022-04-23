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
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("waiting_list")
@ApiModel(value = "WaitingList对象", description = "")
public class WaitingList implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("waiting_list_id")
    private Long waitingListId;

    @TableField("patient_id")
    private Long patientId;

    @TableField("patient_name")
    private String patientName;

    @TableField("patient_age")
    private String patientAge;

    @ApiModelProperty("1-门诊；2-住院；3-体检")
    @TableField("treatment_source")
    private Integer treatmentSource;

    @TableField("treatment_number")
    private String treatmentNumber;

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

    @TableField("sequence_number")
    private String sequenceNumber;

    @TableField("call_number")
    private Integer callNumber;

    @TableField("get_time")
    private LocalDateTime getTime;

    @ApiModelProperty("1-未打印；2-已打印")
    @TableField("print_state")
    private Integer printState;

    @TableField("print_time")
    private LocalDateTime printTime;

    @TableField("call_priority")
    private Integer callPriority;

    @TableField("clct_method")
    private String clctMethod;


}
