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
@TableName("linstqcmonthrpt")
@ApiModel(value = "Linstqcmonthrpt对象", description = "")
public class Linstqcmonthrpt implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    @TableField("chartjson")
    private String chartjson;

    @TableField("loiteminfo")
    private String loiteminfo;

    @TableField("rptinfo")
    private String rptinfo;

    @TableField("labistrmt_id")
    private String labistrmtId;

    @TableField("labistrmt_name")
    private String labistrmtName;

    @TableField("rpt_time")
    private LocalDateTime rptTime;

    @TableField("loitem_name")
    private String loitemName;

    @TableField("loitem_id")
    private String loitemId;

    @TableField("linstqcitem_id")
    private String linstqcitemId;

    @TableField("linstqcitem_name")
    private String linstqcitemName;

    @TableField("status")
    private String status;


}
