package com.lis.baseModel.service.impl;

import com.lis.baseModel.entity.Group;
import com.lis.baseModel.mapper.GroupMapper;
import com.lis.baseModel.service.GroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 检验小组 服务实现类
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements GroupService {

}
