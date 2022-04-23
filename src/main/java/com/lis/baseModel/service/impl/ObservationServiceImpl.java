package com.lis.baseModel.service.impl;

import com.lis.baseModel.entity.Observation;
import com.lis.baseModel.mapper.ObservationMapper;
import com.lis.baseModel.service.ObservationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 检验指标测量值 服务实现类
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Service
public class ObservationServiceImpl extends ServiceImpl<ObservationMapper, Observation> implements ObservationService {

}
