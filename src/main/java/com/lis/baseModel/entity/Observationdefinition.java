package com.lis.baseModel.entity;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Component
@Getter
@Setter
@TableName(value = "observationdefinition",autoResultMap = true)
@ApiModel(value = "Observationdefinition对象", description = "")
public class Observationdefinition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("name")
    private String name;

    @TableField(value = "json",typeHandler = JacksonTypeHandler.class)
    private JSONObject json;

    @TableField("status")
    private String status;

    @TableField("timestamp")
    private Timestamp timestamp;

    @TableField("observationtype")
    private String observationtype;


}
