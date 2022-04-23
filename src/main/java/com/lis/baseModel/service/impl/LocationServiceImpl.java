package com.lis.baseModel.service.impl;

import com.lis.baseModel.entity.Location;
import com.lis.baseModel.mapper.LocationMapper;
import com.lis.baseModel.service.LocationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 位置 服务实现类
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Service
public class LocationServiceImpl extends ServiceImpl<LocationMapper, Location> implements LocationService {

}
