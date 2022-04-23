package com.lis.BaseModel.service.impl;

import com.lis.BaseModel.entity.Condition;
import com.lis.BaseModel.mapper.ConditionMapper;
import com.lis.BaseModel.service.ConditionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 危急值/传染病标记 服务实现类
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Service
public class ConditionServiceImpl extends ServiceImpl<ConditionMapper, Condition> implements ConditionService {

}
