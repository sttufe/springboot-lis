package com.lis.api.Services.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lis.api.Services.MenuServices;
import com.lis.api.entity.Menu;
import com.lis.api.mapper.MenuMapper;
import org.springframework.stereotype.Service;

@Service
public class MenuServicesImp extends ServiceImpl<MenuMapper, Menu> implements MenuServices {

}
