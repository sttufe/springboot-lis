package com.lis.baseData.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lis.baseData.entity.OtherObservationDefine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Utilmapper  extends BaseMapper<Object> {

    @Select("select * from 检验指标_csv")
    List<OtherObservationDefine> getOtherData();
}
