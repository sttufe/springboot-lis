package com.lis.api.Contrller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lis.api.Services.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/")
public class Login {
    @Autowired
    LoginServices loginServices;


    @RequestMapping("/login")
    public JSON login(@RequestBody String json){
        return  loginServices.login(json);};


    @RequestMapping("/logout")
    public JSON logout(){
      return loginServices.logout();}


    @RequestMapping("/info")
    public JSON info(){
       return loginServices.getInfo();}



    @RequestMapping("/table/options")
    public JSON options(){
        return loginServices.options();}

    @RequestMapping("/table")
    public JSON table(@RequestParam(value = "age", required = false, defaultValue = "") Integer age,
                      @RequestParam(value = "current", required = false, defaultValue = "") Integer current,
                      @RequestParam(value = "pageSize", required = false, defaultValue = "") Integer pageSize){
        return  loginServices.table();}


    @RequestMapping("/menu")
    public JSON getMenu(){
        return  loginServices.getMenu();}

}
