package com.lis.api.Contrller;

import com.alibaba.fastjson.JSONObject;
import com.lis.api.Services.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/")
public  class Login {
    @Autowired
    LoginServices loginServices;

    public String logs;

    @RequestMapping("/login")
    public String login(@RequestBody String json){
        return  loginServices.login(json);};


    @RequestMapping("/logout")
    public String logout(){
      return loginServices.logout();}


    @RequestMapping("/info")
    public String info(){
       return loginServices.getInfo();}



    @RequestMapping("/table/options")
    public String options(){
        return loginServices.options();}

    @RequestMapping("/table")
    public String table(@RequestParam(value = "age", required = false, defaultValue = "") Integer age,
                      @RequestParam(value = "current", required = false, defaultValue = "") Integer current,
                      @RequestParam(value = "pageSize", required = false, defaultValue = "") Integer pageSize){
        return  loginServices.table();}


    @RequestMapping("/menu")
    public String getMenu(){
        return  loginServices.getMenu();}



    @RequestMapping("/logs")
    public String log(){

        System.out.println("logs");
        return new JSONObject().toString();}


}
