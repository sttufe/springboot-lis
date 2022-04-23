package com.lis.BaseModel.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("upgrade_record")
@ApiModel(value = "UpgradeRecord对象", description = "")
public class UpgradeRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("upgrade_name")
    private String upgradeName;


}
