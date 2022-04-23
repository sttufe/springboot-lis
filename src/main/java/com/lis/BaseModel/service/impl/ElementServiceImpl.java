package com.lis.BaseModel.service.impl;

import com.lis.BaseModel.entity.Element;
import com.lis.BaseModel.mapper.ElementMapper;
import com.lis.BaseModel.service.ElementService;
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
