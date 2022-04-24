package com.lis.baseData.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lis.baseData.entity.OtherObservationDefine;
import com.lis.baseModel.entity.ObservationRec;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface UtilsMapper extends BaseMapper<Object> {

    @Select("select * from 检验指标_csv")
    List<OtherObservationDefine> getOtherData();


    @Select("select * from observation_rec where  status <>\'${status}\' and   \"issued_datetime\">\'${begin_data}\' and  \"issued_datetime\"<\'${end_data}\'")
    List<ObservationRec> ObservationRec_list  (@Param("begin_data") Timestamp begin_data, @Param("end_data") Timestamp end_data, @Param("status") String status);


    @Select("select count(id) from observation_rec where  status <>\'${status}\' and   \"issued_datetime\">\'${begin_data}\' and  \"issued_datetime\"<\'${end_data}\'")
    int CountObservationByCondition(@Param("begin_data") Timestamp begin_data, @Param("end_data") Timestamp end_data, @Param("status") String status);

}
