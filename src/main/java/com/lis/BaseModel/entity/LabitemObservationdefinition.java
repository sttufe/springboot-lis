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
 * 检验项目指标
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("labitem_observationdefinition")
@ApiModel(value = "LabitemObservationdefinition对象", description = "检验项目指标")
public class LabitemObservationdefinition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("observationdefinition_id")
    private String observationdefinitionId;

    @TableField("lab_item_id")
    private String labItemId;

    @TableField("sno")
    private Integer sno;


}
