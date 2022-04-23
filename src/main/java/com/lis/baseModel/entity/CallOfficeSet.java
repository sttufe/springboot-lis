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
@TableName("call_office_set")
@ApiModel(value = "CallOfficeSet对象", description = "")
public class CallOfficeSet implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("call_office_id")
    private String callOfficeId;

    @TableField("call_office_name")
    private String callOfficeName;

    @ApiModelProperty("1-未启用；2-已启用；3-已停用；")
    @TableField("use_tate")
    private Boolean useTate;

    @TableField("use_time")
    private LocalDateTime useTime;

    @TableField("creater")
    private String creater;

    @TableField("creat_time")
    private LocalDateTime creatTime;

    @TableField("last_reviser")
    private String lastReviser;

    @TableField("last_modify_time")
    private LocalDateTime lastModifyTime;

    @TableField("display_address")
    private String displayAddress;


}
