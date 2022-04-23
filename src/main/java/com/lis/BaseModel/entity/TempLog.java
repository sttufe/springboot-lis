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
 * 合管测试日志
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("temp_log")
@ApiModel(value = "TempLog对象", description = "合管测试日志")
public class TempLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("医嘱id")
    private String 医嘱id;

    @TableField("项目id")
    private String 项目id;

    @TableField("病人id")
    private String 病人id;

    @TableField("患者姓名")
    private String 患者姓名;

    @TableField("就诊类型")
    private String 就诊类型;

    @TableField("采集科室")
    private String 采集科室;

    @TableField("标本类型")
    private String 标本类型;

    @TableField("采集方式")
    private String 采集方式;

    @TableField("采集时机")
    private String 采集时机;

    @TableField("采集部位")
    private String 采集部位;

    @TableField("容器")
    private String 容器;

    @TableField("条码")
    private String 条码;

    @TableField("执行科室")
    private String 执行科室;

    @TableField("默认上机仪器")
    private String 默认上机仪器;


}
