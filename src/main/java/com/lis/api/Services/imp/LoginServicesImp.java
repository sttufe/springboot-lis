package com.lis.api.Services.imp;

import com.lis.api.Services.LoginServices;
import com.lis.api.mapper.LoginServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServicesImp  implements LoginServices {
    @Autowired
    LoginServiceMapper loginServiceMapper;

    @Override
    public void getmenu() {

    }

    @Override
    public int login() {
        System.out.println(loginServiceMapper.getLoginUser("admin").getUsername());
    return 0;}
}
