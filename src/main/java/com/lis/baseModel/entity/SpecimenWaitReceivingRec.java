package com.lis.baseModel.entity;

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
 * 标本待签收记录
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("specimen_wait_receiving_rec")
@ApiModel(value = "SpecimenWaitReceivingRec对象", description = "标本待签收记录")
public class SpecimenWaitReceivingRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("receiving_id")
    private Integer receivingId;

    @TableField("organization_id")
    private String organizationId;

    @TableField("location_id")
    private String locationId;

    @TableField("send_no")
    private String sendNo;

    @TableField("send_datetime")
    private LocalDateTime sendDatetime;

    @TableField("sndr_no")
    private String sndrNo;

    @TableField("sndr_id")
    private String sndrId;

    @TableField("procedure_id")
    private Integer procedureId;


}
