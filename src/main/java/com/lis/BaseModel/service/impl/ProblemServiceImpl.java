package com.lis.BaseModel.service.impl;

import com.lis.BaseModel.entity.Problem;
import com.lis.BaseModel.mapper.ProblemMapper;
import com.lis.BaseModel.service.ProblemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 问题列表 服务实现类
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Service
public class ProblemServiceImpl extends ServiceImpl<ProblemMapper, Problem> implements ProblemService {

}
