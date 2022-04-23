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
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("many_call_record")
@ApiModel(value = "ManyCallRecord对象", description = "")
public class ManyCallRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("many_call_record_id")
    private Long manyCallRecordId;

    @TableField("sequence_number")
    private String sequenceNumber;

    @TableField("called_list_id")
    private Long calledListId;

    @TableField("call_window_id")
    private String callWindowId;

    @TableField("call_window_name")
    private String callWindowName;

    @TableField("callers")
    private String callers;

    @TableField("get_time")
    private LocalDateTime getTime;


}
