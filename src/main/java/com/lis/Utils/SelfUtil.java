package com.lis.Utils;


import org.springframework.stereotype.Component;

@Component
public  class SelfUtil {
    public static  String  IsNull(Object object){
        String r="";
        if(object==null){
            r="";
        }else{r=object.toString();}
        return  r;
    }


}
