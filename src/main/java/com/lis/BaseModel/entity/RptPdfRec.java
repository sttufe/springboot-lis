package com.lis.BaseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
@TableName("rpt_pdf_rec")
@ApiModel(value = "RptPdfRec对象", description = "")
public class RptPdfRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("pid")
    private BigDecimal pid;

    @TableField("pat_name")
    private String patName;

    @TableField("encounter_type_code")
    private String encounterTypeCode;

    @TableField("encounter_type")
    private String encounterType;

    @TableField("encounter_no")
    private String encounterNo;

    @TableField("rpt_id")
    private String rptId;

    @TableField("source_system")
    private String sourceSystem;

    @TableField("publish_time")
    private String publishTime;

    @TableField("publish_count")
    private Integer publishCount;

    @TableField("publish_err")
    private String publishErr;

    @TableField("publish_status")
    private String publishStatus;

    @TableField("lastupdate_time")
    private LocalDateTime lastupdateTime;

    @TableField("is_lock")
    private Boolean isLock;

    @TableField("publish_info")
    private String publishInfo;

    @TableField("audit_practitioner_id")
    private String auditPractitionerId;

    @TableField("publish_practitioner_id")
    private String publishPractitionerId;

    @TableField("publish_user_name")
    private String publishUserName;

    @TableField("publish_mac")
    private String publishMac;

    @TableField("publish_ip")
    private String publishIp;


}
