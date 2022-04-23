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
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("linstqc_comparison_test")
@ApiModel(value = "LinstqcComparisonTest对象", description = "")
public class LinstqcComparisonTest implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId("test_id")
    private Long testId;

    @ApiModelProperty("试验日期")
    @TableField("test_time")
    private LocalDateTime testTime;

    @ApiModelProperty("{		\"test_id\": \"id\",		\"testno\": \"试验编号\",		\"testname\": \"试验名称\",		\"testmethod_code\": \"试验方法编码\",		\"testmethod\": \"试验方法\",		\"test_time\": \"试验日期\",		\"organization_id\": \"组织ID\",		\"location_name\": \"组织名称\",		\"registrant\": \"登记人\",		\"registration_time\": \"登记时间\",		\"auditer\": \"完成人\",		\"audit_time\": \"完成时间\",		\"test_times\":\"检测次数\",		\"test_type\":\"测试类型\",		\"status\": \"状态\"	}")
    @TableField("json")
    private String json;

    @ApiModelProperty("状态")
    @TableField("status")
    private String status;

    @TableField("group_id")
    private String groupId;


}
