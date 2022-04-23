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
@TableName("micreviewobservation")
@ApiModel(value = "Micreviewobservation对象", description = "")
public class Micreviewobservation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    @TableField("observation_name")
    private String observationName;

    @TableField("observation_id")
    private String observationId;

    @TableField("specim_id")
    private Long specimId;

    @TableField("value")
    private String value;

    @TableField("observationset_name")
    private String observationsetName;

    @TableField("observationset_id")
    private String observationsetId;

    @TableField("json")
    private String json;

    @TableField("status")
    private String status;


}
