package com.lis.BaseModel.entity;

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
@TableName("ob_temp")
@ApiModel(value = "ObTemp对象", description = "")
public class ObTemp implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("编码")
    private String 编码;

    @TableField("序号")
    private Integer 序号;


}
