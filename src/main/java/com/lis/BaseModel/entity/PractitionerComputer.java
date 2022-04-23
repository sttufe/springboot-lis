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
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("practitioner_computer")
@ApiModel(value = "PractitionerComputer对象", description = "")
public class PractitionerComputer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("user")
    private String user;

    @TableField("hisid")
    private String hisid;

    @TableField("password")
    private String password;

    @TableField("capassword")
    private String capassword;

    @TableField("practitionerid")
    private String practitionerid;

    @TableField("locked")
    private Boolean locked;

    @TableField("loginerrcount")
    private Integer loginerrcount;


}
