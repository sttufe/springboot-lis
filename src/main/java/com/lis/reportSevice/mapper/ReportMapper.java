package com.lis.reportSevice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lis.baseModel.entity.ServicerequestRec;
import com.lis.baseModel.entity.Specimen;
import com.lis.baseModel.entity.SpecimenRec;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;


@Mapper
public interface ReportMapper extends BaseMapper<Object> {
   // @Select("select * from observation_rec where  status <>\'${status}\' and   \"issued_datetime\">\'${begin_data}\' and  \"issued_datetime\"<\'${end_data}\'")
    @Select("select *  from servicerequest_rec s  where  status <>\'${status}\' and  \"servicerequest_authoredon\" >\'${b_data}\'  and \"servicerequest_authoredon\" <\'${e_data}\' ")
    List<ServicerequestRec> getServicerequestRecs(@Param("b_data") String b_data, @Param("e_data") String e_data,String status);


    @Select("select  *   from  specimen s  where id in(select id from specimen_rec sr  where sr.pat_name <>'无主标本'  and  sr.coll_time>\'${b_data}\' and   sr.coll_time<\'${e_data}\')")
    List<Specimen> getSpecimens(@Param("b_data") String b_data, @Param("e_data") String e_data);



    @Select("SELECT id,pid,pat_name,encounter,encounter_servicetype,servicerequest_code,servicerequest_authoredon," +
            "pat_infctdz_sign,priority,status,requisition_value,servicerequest_organization,procedure_id,ex_condition_code," +
            "ex_condition_display,\"basedOn_reference\",ex_source_system,ex_eobject,ex_egcode,ex_egname,ex_etaskno,ex_etaskname," +
            "ex_id_card_no,ex_visit_card_no,calculation_num,unitcode,unitname FROM servicerequest_rec WHERE id=\'${id}\'")
    ServicerequestRec getSpecimen(@Param("id") String id);


    @Select("select id from specimen_rec sr  where sr.pat_name <>'无主标本'  and  sr.coll_time>\'${b_data}\' and   sr.coll_time<\'${e_data}\'")
    List<Integer> getSpecimenRec(@Param("b_data") String b_data, @Param("e_data") String e_data);

    @Select("select id from observation_rec or2  where \"specimen_reference1Specimen\" =\'${specimen_id}\'")
    Set<Integer> getObservationRecIds(@Param("specimen_id") Integer specimen_id);


    @Select("SELECT id,identifier_value1bc,pid,pat_name,specimen_id,status,infctdz_sign,priority,condition_code,collection_id," +
            "procedure_id,splitstatus,split_value1bc,encounter_type_code,encounter_type,encounter_no,\"uniqueId\",ex_eobject,ex_egcode," +
            "ex_egname,ex_etaskno,ex_etaskname,ex_id_card_no,ex_visit_card_no,duplex_identification,unitcode,unitname FROM specimen_rec " +
            "WHERE id=\'${id}\'")
    SpecimenRec getSpecimenRecById(@Param( "id")Integer id);
}
