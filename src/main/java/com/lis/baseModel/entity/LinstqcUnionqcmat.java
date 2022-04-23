package com.lis.baseModel.entity;

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
@TableName("linstqc_unionqcmat")
@ApiModel(value = "LinstqcUnionqcmat对象", description = "")
public class LinstqcUnionqcmat implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("name")
    private String name;

    @TableField("labistrmt_id")
    private String labistrmtId;

    @TableField("labistrmt_name")
    private String labistrmtName;

    @TableField("qcmat_time")
    private LocalDateTime qcmatTime;

    @TableField("qcmat_begtime")
    private LocalDateTime qcmatBegtime;

    @TableField("qcmat_batch")
    private String qcmatBatch;

    @TableField("qcmat_producer")
    private String qcmatProducer;

    @TableField("status")
    private String status;


}
