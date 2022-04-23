package com.lis.BaseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 标本送检记录
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("specimen_submitted_rec")
@ApiModel(value = "SpecimenSubmittedRec对象", description = "标本送检记录")
public class SpecimenSubmittedRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("send_no")
    private String sendNo;

    @TableField("procedure_id")
    private Integer procedureId;

    @TableField("sndr_no")
    private String sndrNo;

    @TableField("sndr_id")
    private String sndrId;

    @TableField("specimen_json")
    private String specimenJson;

    @TableField("send_organization_id")
    private String sendOrganizationId;

    @TableField("receiving_organization_id")
    private String receivingOrganizationId;

    @TableField("status")
    private String status;

    @TableField("submitted_datetime")
    private LocalDateTime submittedDatetime;


}
