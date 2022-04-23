package com.lis.reportSevice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lis.baseModel.entity.ObservationRec;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface UtilsMapper extends BaseMapper<Object> {

    @Select("select * from observation_rec where  status <>\'${status}\' and   \"issued_datetime\">\'${begin_data}\' and  \"issued_datetime\"<\'${end_data}\'")
    List<ObservationRec> ObservationRec_list  (@Param("begin_data") Timestamp begin_data, @Param("end_data") Timestamp end_data, @Param("status") String status);


    @Select("select count(id) from observation_rec where  status <>\'${status}\' and   \"issued_datetime\">\'${begin_data}\' and  \"issued_datetime\"<\'${end_data}\'")
    int CountObservationByCondition(@Param("begin_data") Timestamp begin_data, @Param("end_data") Timestamp end_data, @Param("status") String status);


}
