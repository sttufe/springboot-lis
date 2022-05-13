package com.lis.api.Contrller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lis.api.Services.LoginServices;
import com.lis.api.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Login {
    @Autowired
    LoginServices loginServices;

    @RequestMapping("/login")
    public JSON login(){
        loginServices.login();

        Result result=new Result();
        result.setCode(200);
        result.setToken("Token123456");
        result.setMessage("登陆成功");
        System.out.println(JSONObject.toJSON(result).toString());
        return (JSON)JSONObject.toJSON(result);
    };

    @RequestMapping("/info")
    public String info(){

        return "info";
    }

    public String getMenu(){
        return "ok";
    }

}
