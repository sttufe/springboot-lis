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
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("nodemsg")
@ApiModel(value = "Nodemsg对象", description = "")
public class Nodemsg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("nodemsgid")
    private String nodemsgid;

    @TableField("msg")
    private String msg;


}
