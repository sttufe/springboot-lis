package com.lis.BaseModel.mapper;

import com.lis.BaseModel.entity.Invoice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 账单 Mapper 接口
 * </p>
 *
 * @author koli
 * @since 2022-03-19
 */
@Mapper
public interface InvoiceMapper extends BaseMapper<Invoice> {

}
