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
 * 设备厂商信息
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("eprentp")
@ApiModel(value = "Eprentp对象", description = "设备厂商信息")
public class Eprentp implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("设备生产商id")
    @TableId("eprentp_id")
    private String eprentpId;

    @ApiModelProperty("设备生产商名称")
    @TableField("eprentp_name")
    private String eprentpName;

    @ApiModelProperty("备注")
    @TableField("eprentp_desc")
    private String eprentpDesc;

    @ApiModelProperty("使用状态")
    @TableField("use_sign")
    private String useSign;

    @ApiModelProperty("最后更新时间")
    @TableField("last_updatetime")
    private LocalDateTime lastUpdatetime;


}
