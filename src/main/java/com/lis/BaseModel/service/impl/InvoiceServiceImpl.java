package com.lis.BaseModel.service.impl;

import com.lis.BaseModel.entity.Invoice;
import com.lis.BaseModel.mapper.InvoiceMapper;
import com.lis.BaseModel.service.InvoiceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账单 服务实现类
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Service
public class InvoiceServiceImpl extends ServiceImpl<InvoiceMapper, Invoice> implements InvoiceService {

}
