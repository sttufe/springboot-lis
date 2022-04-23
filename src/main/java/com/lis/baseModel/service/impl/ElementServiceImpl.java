package com.lis.baseModel.service.impl;

import com.lis.baseModel.entity.Element;
import com.lis.baseModel.mapper.ElementMapper;
import com.lis.baseModel.service.ElementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 要素定义 服务实现类
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Service
public class ElementServiceImpl extends ServiceImpl<ElementMapper, Element> implements ElementService {

}
