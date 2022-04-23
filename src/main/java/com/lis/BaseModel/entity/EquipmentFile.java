package com.lis.BaseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.sql.Timestamp;

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
@TableName("equipment_file")
@ApiModel(value = "EquipmentFile对象", description = "")
public class EquipmentFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId("id")
    private String id;

    @TableField("equipment_id")
    private String equipmentId;

    @ApiModelProperty("文件名称")
    @TableField("file_name")
    private String fileName;

    @TableField("file_type")
    private String fileType;

    @ApiModelProperty("归档否；1：归档，2，未归档")
    @TableField("archive")
    private String archive;

    @ApiModelProperty("文档路径")
    @TableField("file_address")
    private String fileAddress;

    @ApiModelProperty("上传时间")
    @TableField("upload_data")
    private Timestamp uploadData;


}
