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
 * 待签收标本
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("wait_receiving_specimen")
@ApiModel(value = "WaitReceivingSpecimen对象", description = "待签收标本")
public class WaitReceivingSpecimen implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("receiving_id")
    private Integer receivingId;

    @TableField("specimen_id")
    private Integer specimenId;


}
