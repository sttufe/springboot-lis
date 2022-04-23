package com.lis.BaseModel.service.impl;

import com.lis.BaseModel.entity.WebMessage;
import com.lis.BaseModel.mapper.WebMessageMapper;
import com.lis.BaseModel.service.WebMessageService;
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
