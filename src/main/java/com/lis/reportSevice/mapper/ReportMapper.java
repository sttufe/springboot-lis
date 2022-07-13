package com.lis.reportSevice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lis.baseModel.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Set;


@Mapper
public interface ReportMapper extends BaseMapper<Object> {
   // @Select("select * from observation_rec where  status <>\'${status}\' and   \"issued_datetime\">\'${begin_data}\' and  \"issued_datetime\"<\'${end_data}\'")
    @Select("select *  from servicerequest_rec s  where  status <>\'${status}\' and  \"servicerequest_authoredon\" >\'${b_data}\'  and \"servicerequest_authoredon\" <\'${e_data}\' ")
    List<ServicerequestRec> getServicerequestRecs(@Param("b_data") String b_data, @Param("e_data") String e_data,String status);


    @Select("select  *   from  specimen s  where id in(select id from specimen_rec sr  where sr.pat_name <>'无主标本'  and  sr.coll_time>\'${b_data}\' and   sr.coll_time<\'${e_data}\')")
    List<Specimen> getSpecimens(@Param("b_data") String b_data, @Param("e_data") String e_data);


    /**
     * 获取单个标本
     * @param id
     * @return
     */
    @Select("SELECT id,pid,pat_name,encounter,encounter_servicetype,servicerequest_code,servicerequest_authoredon," +
            "pat_infctdz_sign,priority,status,requisition_value,servicerequest_organization,procedure_id,ex_condition_code," +
            "ex_condition_display,\"basedOn_reference\",ex_source_system,ex_eobject,ex_egcode,ex_egname,ex_etaskno,ex_etaskname," +
            "ex_id_card_no,ex_visit_card_no,calculation_num,unitcode,unitname FROM servicerequest_rec WHERE id=\'${id}\'")
     ServicerequestRec getSpecimen(@Param("id") String id);


    /**
     * 获取单个指标
     * @param specimen_id
     * @return
     */
    @Select("select id from observation_rec or2  where \"specimen_reference1Specimen\" =\'${specimen_id}\'")
    Set<Integer> getObservationRecIds(@Param("specimen_id") Integer specimen_id);

 /**
  * 根据id获取单个SpecimenRec
  * @param id
  * @return
  */
    @Select("SELECT id,identifier_value1bc,pid,pat_name,specimen_id,status,infctdz_sign,priority,condition_code,collection_id," +
            "procedure_id,splitstatus,split_value1bc,encounter_type_code,encounter_type,encounter_no,\"uniqueId\",ex_eobject,ex_egcode," +
            "ex_egname,ex_etaskno,ex_etaskname,ex_id_card_no,ex_visit_card_no,duplex_identification,unitcode,unitname FROM specimen_rec " +
            "WHERE id=\'${id}\'")
    SpecimenRec getSpecimenRecById(@Param( "id")Integer id);


    /**
     *查询所有符合条件的标本
     * @param b_data
     * @param e_data
     * @param quest_data  加上申请时间
     * @param SQLCondition 自定义Sql 以 and 开头
     * @return
     */
    @Select("select id from specimen_rec sr2  where id in (\n" +
        "select specmids::integer from diagnosticreport_rec dr   where specmids::integer in (select id  from specimen_rec sr  where sr.collection_id in (\n" +
        "select collection_id from servicerequest_collection sc  where   servicerequest_id in (\n" +
        "select id from servicerequest_rec sr  where  sr.status='active'  and  sr.servicerequest_authoredon between  \'${quest_data}\' and \'${e_data}\' ${SQLCondition} \n" +
        "))) and   issued between  \'${b_data}\' and \'${e_data}\') ")
 List<Integer> getSpecimenRec(@Param("b_data") String b_data,
                              @Param("e_data") String e_data,
                              @Param("quest_data") String quest_data,
                              @Param("SQLCondition") String SQLCondition);


//所有申请
 @Select("select * from servicerequest s where   status = \'active\' and   \"timestamp\"  between   \'${b_data}\'  and  \'${e_data}\'       ${SQLCondition}")
 List<Servicerequest> getServicerequests(@Param("b_data") String b_data,
                                         @Param("e_data") String e_data,
                                         @Param("SQLCondition") String SQLCondition);


 //根绝标本id 查询指标
    @Select("select *  from observation o2  where id in (\n" +
            "select id   from observation_rec or2 where \"specimen_reference1Specimen\" =\'${specimen_id}\' and status<>'cancelled') ")
    List<Observation> getObservations(@Param("specimen_id") Integer specimen_id);

}
