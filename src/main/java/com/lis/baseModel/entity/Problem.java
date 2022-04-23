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
 * 问题列表
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("problem")
@ApiModel(value = "Problem对象", description = "问题列表")
public class Problem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("term_chn")
    private String termChn;

    @TableField("specifiedname")
    private String specifiedname;

    @TableField("fullyspecifiedname")
    private String fullyspecifiedname;

    @TableField("guid")
    private String guid;


}
