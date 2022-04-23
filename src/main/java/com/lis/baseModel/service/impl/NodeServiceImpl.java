package com.lis.baseModel.service.impl;

import com.lis.baseModel.entity.Node;
import com.lis.baseModel.mapper.NodeMapper;
import com.lis.baseModel.service.NodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Service
public class NodeServiceImpl extends ServiceImpl<NodeMapper, Node> implements NodeService {

}
