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
 * 临生免系统信息
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("web_lab_system")
@ApiModel(value = "WebLabSystem对象", description = "临生免系统信息")
public class WebLabSystem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("系统版本号")
    @TableId("system_version")
    private String systemVersion;

    @ApiModelProperty("文件版本号")
    @TableField("file_version")
    private String fileVersion;

    @ApiModelProperty("更新说明")
    @TableField("update_info")
    private String updateInfo;

    @ApiModelProperty("更新时间")
    @TableField("timestamp")
    private LocalDateTime timestamp;


}
