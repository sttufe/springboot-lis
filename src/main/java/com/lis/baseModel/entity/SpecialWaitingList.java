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
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("special_waiting_list")
@ApiModel(value = "SpecialWaitingList对象", description = "")
public class SpecialWaitingList implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("many_call_record_id")
    private String manyCallRecordId;

    @TableField("sequence_number")
    private String sequenceNumber;

    @TableField("get_time")
    private LocalDateTime getTime;

    @TableField("call_number")
    private Integer callNumber;

    @TableField("call_priority")
    private Integer callPriority;

    @TableField("called_list_id")
    private Long calledListId;


}
