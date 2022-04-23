package com.lis.api.Test.WhenThreadDone;

import lombok.Data;

@Data
public class ReturnData {
    /**
     * 线程
     */
    public Thread thread;

    /**
     * 当前线程执行任务所保存的数据
     */
    public Object data;
}