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
@TableName("reviewobservation")
@ApiModel(value = "Reviewobservation对象", description = "")
public class Reviewobservation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("observationid")
    private String observationid;

    @TableField("observationname")
    private String observationname;

    @TableField("ruleid")
    private String ruleid;

    @TableField("observationsetid")
    private String observationsetid;

    @TableField("observationsetname")
    private String observationsetname;


}
