package com.lis.baseModel.entity;

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
 * 标本拒收待处理记录
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("specimen_refuse_wait_rec")
@ApiModel(value = "SpecimenRefuseWaitRec对象", description = "标本拒收待处理记录")
public class SpecimenRefuseWaitRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("bc_no")
    private String bcNo;

    @TableField("pat_name")
    private String patName;

    @TableField("organization_id")
    private String organizationId;

    @TableField("location_id")
    private String locationId;

    @TableField("refuse_datetime")
    private LocalDateTime refuseDatetime;

    @TableField("pid")
    private BigDecimal pid;

    @TableField("procedure_id")
    private Integer procedureId;


}
