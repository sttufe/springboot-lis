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
 * 
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("hisconnection")
@ApiModel(value = "Hisconnection对象", description = "")
public class Hisconnection implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("ip")
    private String ip;

    @TableField("port")
    private String port;

    @TableField("dbname")
    private String dbname;

    @TableField("account")
    private String account;

    @TableField("connectionstr")
    private String connectionstr;

    @TableField("status")
    private String status;


}
