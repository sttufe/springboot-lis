package com.lis.BaseModel.mapper;

import com.lis.BaseModel.entity.Condition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 危急值/传染病标记 Mapper 接口
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Mapper
public interface ConditionMapper extends BaseMapper<Condition> {

}
