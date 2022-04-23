package com.lis.api.Contrller;


import com.lis.api.Services.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
public class Login {

    @Autowired
    LoginServices loginServices;

    public String getmenu(){

        loginServices.getmenu();
        return null;
    };




}
