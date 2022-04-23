package com.lis.baseModel.mapper;

import com.lis.baseModel.entity.Problem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 问题列表 Mapper 接口
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Mapper
public interface ProblemMapper extends BaseMapper<Problem> {

}
