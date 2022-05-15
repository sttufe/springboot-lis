package com.lis.api.Services;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

@Service
public interface LoginServices {

    JSON login(String json);
    JSON logout();
    JSON getInfo();
    JSON getMenu();
    JSON options();
    JSON table();


}
