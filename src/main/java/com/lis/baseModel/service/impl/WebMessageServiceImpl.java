package com.lis.baseModel.service.impl;

import com.lis.baseModel.entity.WebMessage;
import com.lis.baseModel.mapper.WebMessageMapper;
import com.lis.baseModel.service.WebMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消息记录表 服务实现类
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Service
public class WebMessageServiceImpl extends ServiceImpl<WebMessageMapper, WebMessage> implements WebMessageService {

}
