package com.lis.api.Test.WhenThreadDone;


import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;

@Data
public class MyThread {
    public ArrayList<Thread> threads;

    // 用来保存线程执行任务中需要返回数据的对象（线程要返回什么数据 就往这个对象里塞值就行了）
    public ArrayList<ReturnData> returnDataList;

    public MyThread() {
        this.threads = new ArrayList<>();
        this.returnDataList = new ArrayList<>();
    }


    /**
     * 创建线程并给线程添加任务
     * 备注：
     * 1、此方法仅需把 new Job().print(returnDataList, taskParam) 替换为待执行的任务方法即可
     * 2、taskParam 随任务的参数而定
     *
     * @param threadCount 要创建的线程数量
     * @param taskParam   任务的参数
     * @return
     */
    public MyThread setup1CreateThread(int threadCount, String taskParam) {
        for (int i = 0; i < threadCount; i++) {
            // new Job().print(returnDataList, taskParam) 为线程要执行的任务
            Thread th = new Thread(() -> new Job().print(returnDataList, taskParam));
            // 设置线程名称
            th.setName(String.format("MyThread-%s", i + 1));
            threads.add(th);
        }
        return this;
    }

    /**
     * 批量启动所有线程
     * 备注：此方法不用修改
     *
     * @return
     */
    public MyThread setup2Starts() {
        for (Thread thread : threads) {
            thread.start();
        }
        return this;
    }

    /**
     * 等待threads中的所有线程都结束（再开始执行主线程）
     * 备注：此方法不用修改
     *
     * @return
     */
    public MyThread setup3WaitThreadEnd() {
        while (true) {
            ArrayList<String> thStates = new ArrayList<>();
            for (Thread thread : threads) {
                thStates.add(thread.getState().name());
            }
            // 第一个线程的状态为终止状态 && 所有线程的状态去重后数量为1（表示所有的线程状态都相同）
            if (threads.get(0).getState().name().equals("TERMINATED") && new HashSet<Object>(thStates).size() == 1) {
                break;
            }
        }
        return this;
    }


    public static void main(String[] args) {
        MyThread myThread = new MyThread()
                // 1 创建线程并给线程添加任务（此时线程还未执行）
                .setup1CreateThread(10, "这是任务的参数")
                // 2 批量启动所有线程
                .setup2Starts()
                // 3 等待创建的线程 中的 所有线程都结束（再开始执行主线程）
                .setup3WaitThreadEnd();

        System.out.println("创建的所有线程执行完后 才会执行此行");

        for (ReturnData returnData : myThread.returnDataList) {
            System.out.println(String.format("线程执行任务的返回数据：%s %s", returnData.thread.getName(), returnData.data));
        }
    }
}