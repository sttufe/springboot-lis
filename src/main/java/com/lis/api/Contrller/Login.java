package com.lis.api.Contrller;


import com.lis.api.Services.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class Login {
    @Autowired
    LoginServices loginServices;

    @RequestMapping("/v1")
    public String login(){
        loginServices.login();
        return "ok";
    };

    public String getMenu(){
        return "ok";
    }

}
