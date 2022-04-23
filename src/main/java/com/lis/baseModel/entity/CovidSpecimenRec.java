package com.lis.baseModel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 核酸检测平台标本信息
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Getter
@Setter
@TableName("covid_specimen_rec")
@ApiModel(value = "CovidSpecimenRec对象", description = "核酸检测平台标本信息")
public class CovidSpecimenRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId("id")
    private Integer id;

    @ApiModelProperty("系统编码")
    @TableField("system_code")
    private String systemCode;

    @ApiModelProperty("系统名称")
    @TableField("system")
    private String system;

    @ApiModelProperty("标本ID")
    @TableField("spcm_id")
    private BigDecimal spcmId;

    @ApiModelProperty("报告ID")
    @TableField("rpt_id")
    private BigDecimal rptId;

    @ApiModelProperty("标本条码")
    @TableField("spcm_bc")
    private String spcmBc;

    @ApiModelProperty("送检单号")
    @TableField("send_bc")
    private String sendBc;

    @ApiModelProperty("检验项目ID")
    @TableField("labitem_id")
    private String labitemId;

    @ApiModelProperty("检验项目编码")
    @TableField("labitem_code")
    private String labitemCode;

    @ApiModelProperty("检验项目名称")
    @TableField("labitem_name")
    private String labitemName;

    @ApiModelProperty("标本类型编码|（1-鼻拭子；2-咽拭子；3-鼻咽拭子） ")
    @TableField("spcm_type_code")
    private String spcmTypeCode;

    @ApiModelProperty("标本类型|（1-鼻拭子；2-咽拭子；3-鼻咽拭子）")
    @TableField("spcm_type")
    private String spcmType;

    @ApiModelProperty("采集点MAC")
    @TableField("collct_mac")
    private String collctMac;

    @ApiModelProperty("采集点IP")
    @TableField("collct_ip")
    private String collctIp;

    @ApiModelProperty("采集点")
    @TableField("collct_ssite")
    private String collctSsite;

    @ApiModelProperty("采集人")
    @TableField("collct_staff")
    private String collctStaff;

    @ApiModelProperty("采集科室")
    @TableField("collct_dept")
    private String collctDept;

    @ApiModelProperty("采集时间")
    @TableField("collct_time")
    private LocalDateTime collctTime;

    @ApiModelProperty("送检人")
    @TableField("send_staff")
    private String sendStaff;

    @ApiModelProperty("送检科室")
    @TableField("send_dept")
    private String sendDept;

    @ApiModelProperty("送检组织编码")
    @TableField("send_org_code")
    private String sendOrgCode;

    @ApiModelProperty("送检组织")
    @TableField("send_org")
    private String sendOrg;

    @ApiModelProperty("送检时间")
    @TableField("send_time")
    private LocalDateTime sendTime;

    @ApiModelProperty("上机实验室编码")
    @TableField("laboratory_code")
    private String laboratoryCode;

    @ApiModelProperty("上机实验室")
    @TableField("laboratory")
    private String laboratory;

    @ApiModelProperty("核收人")
    @TableField("chkrcv_staff")
    private String chkrcvStaff;

    @ApiModelProperty("核收科室")
    @TableField("chkrcv_dept")
    private String chkrcvDept;

    @ApiModelProperty("核收时间")
    @TableField("chkrcv_time")
    private LocalDateTime chkrcvTime;

    @ApiModelProperty("报告人")
    @TableField("report_staff")
    private String reportStaff;

    @ApiModelProperty("报告科室")
    @TableField("report_dept")
    private String reportDept;

    @ApiModelProperty("报告时间")
    @TableField("report_time")
    private LocalDateTime reportTime;

    @ApiModelProperty("混检比例|（10、5、1）")
    @TableField("test_ratio")
    private String testRatio;

    @ApiModelProperty("标本状态|（已送检、已核收、已报告）")
    @TableField("spcm_state")
    private String spcmState;

    @ApiModelProperty("检测结果（0-阴性；1-阳性）")
    @TableField("result")
    private String result;

    @ApiModelProperty("患者ID")
    @TableField("pid")
    private String pid;

    @ApiModelProperty("患者姓名")
    @TableField("pat_name")
    private String patName;

    @ApiModelProperty("性别编码|（1-男；2-女；0-未知；9-未明）")
    @TableField("gender_code")
    private String genderCode;

    @ApiModelProperty("性别|（1-男；2-女；0-未知；9-未明）")
    @TableField("gender")
    private String gender;

    @ApiModelProperty("年龄")
    @TableField("age")
    private String age;

    @ApiModelProperty("身份证号")
    @TableField("idcard")
    private String idcard;

    @ApiModelProperty("出生日期")
    @TableField("birthday")
    private String birthday;

    @ApiModelProperty("国籍")
    @TableField("nationality")
    private String nationality;

    @ApiModelProperty("民族")
    @TableField("nation")
    private String nation;

    @ApiModelProperty("籍贯")
    @TableField("hometown")
    private String hometown;

    @ApiModelProperty("地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("联系电话")
    @TableField("phone_number")
    private String phoneNumber;

    @ApiModelProperty("紧急联系人")
    @TableField("emergency_contact")
    private String emergencyContact;

    @ApiModelProperty("紧急联系人电话")
    @TableField("emergency_phone")
    private String emergencyPhone;


}
