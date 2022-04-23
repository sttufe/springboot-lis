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
@TableName("node")
@ApiModel(value = "Node对象", description = "")
public class Node implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("pindex")
    private String pindex;

    @TableField("msgid")
    private String msgid;

    @TableField("op")
    private String op;

    @TableField("nodeid")
    private String nodeid;

    @TableField("nodename")
    private String nodename;

    @TableField("nodetype")
    private String nodetype;

    @TableField("nodetime")
    private LocalDateTime nodetime;

    @TableField("outmsg")
    private String outmsg;

    @TableField("runtime")
    private Double runtime;

    @TableField("othernode")
    private String othernode;

    @TableField("paramstr")
    private String paramstr;


}
