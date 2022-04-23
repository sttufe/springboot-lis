package com.lis.api.Test.WhenThreadDone;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Job {
    /**
     * 要让线程执行的任务
     *
     * @param returnDataList 用来保存线程执行任务中需要返回数据的对象（线程要返回什么数据 就往这个对象里塞值就行了）
     * @param count          任务的参数
     */
    public void print(ArrayList<ReturnData> returnDataList, String count) {
        String data = String.format("[%s][%s]%s",
                Thread.currentThread().getName(),
                count,
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSS").format(new Date())
        );
        System.out.println(data);

        // 在任务中把要返回的数据添加到returnData对象中
        ReturnData returnData = new ReturnData();
        returnData.thread = Thread.currentThread();
        returnData.data = data;
        returnDataList.add(returnData);
    }
}
