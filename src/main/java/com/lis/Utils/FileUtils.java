package com.lis.Utils;


import java.io.FileWriter;
import java.io.IOException;



public  class FileUtils {

    public static   void Save(String FilePath, String Content) throws IOException {
        String Filename= DateUtils.getCurrentYMDHMSStr().substring(0,10)+".log";
        java.io.File file = new java.io.File(FilePath, Filename);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdir();
        }
            FileWriter fileWriter = new FileWriter(file,true);
            fileWriter.write(Content);
            fileWriter.flush();
            fileWriter.close();
    }
}
