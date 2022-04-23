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
@TableName("msgreceive")
@ApiModel(value = "Msgreceive对象", description = "")
public class Msgreceive implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("msgid")
    private String msgid;

    @TableField("msgsize")
    private Double msgsize;

    @TableField("nodetime")
    private LocalDateTime nodetime;

    @TableField("note")
    private String note;


}
