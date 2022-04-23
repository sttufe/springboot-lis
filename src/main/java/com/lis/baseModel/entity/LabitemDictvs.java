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
 * 项目对照表
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("labitem_dictvs")
@ApiModel(value = "LabitemDictvs对象", description = "项目对照表")
public class LabitemDictvs implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("项目id")
    @TableId("labitem_id")
    private String labitemId;

    @ApiModelProperty("项目名称")
    @TableField("labitem_name")
    private String labitemName;

    @ApiModelProperty("项目编码")
    @TableField("labitem_code")
    private String labitemCode;

    @ApiModelProperty("三方编码")
    @TableField("third_code")
    private String thirdCode;

    @ApiModelProperty("三方名称")
    @TableField("third_name")
    private String thirdName;

    @ApiModelProperty("三方系统")
    @TableField("third_source")
    private String thirdSource;

    @TableField("publisher")
    private String publisher;

    @TableField("publisher_id")
    private String publisherId;

    @TableField("publisher_time")
    private LocalDateTime publisherTime;

    @ApiModelProperty("主键")
    @TableField("id")
    private Integer id;

    @TableField("type")
    private String type;


}
