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
@TableName("nodepara")
@ApiModel(value = "Nodepara对象", description = "")
public class Nodepara implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("paramid")
    private String paramid;

    @TableField("paramstr")
    private String paramstr;


}
