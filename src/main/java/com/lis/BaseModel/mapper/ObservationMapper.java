package com.lis.BaseModel.mapper;

import com.lis.BaseModel.entity.Observation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 检验指标测量值 Mapper 接口
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Mapper
public interface ObservationMapper extends BaseMapper<Observation> {

}
