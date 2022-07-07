package com.lis.Utils;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public  class LogsUtil {

    public static   void Save(String FilePath, String Content) throws IOException {
        String Filename= DateUtils.getCurrentYMDHMSStr().substring(0,10)+".log";
        File file = new File(FilePath+"\\logs", Filename);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdir();
        }
            FileWriter fileWriter = new FileWriter(file,true);
            fileWriter.write(Content);
            fileWriter.flush();
            fileWriter.close();
    }
}
