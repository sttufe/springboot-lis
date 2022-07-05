package com.lis.api.Services;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

@Service
public interface LoginServices {

    String login(String json);
    String logout();
    String getInfo();
    String getMenu();
    String options();
    String table();


}
