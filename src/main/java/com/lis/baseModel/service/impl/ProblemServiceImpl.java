package com.lis.baseModel.service.impl;

import com.lis.baseModel.entity.Problem;
import com.lis.baseModel.mapper.ProblemMapper;
import com.lis.baseModel.service.ProblemService;
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
