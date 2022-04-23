package com.lis.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class ForTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("----程序开始运行----");
        Date beginTime = new Date();
        // 创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(1000);

        //当前任务数量
        int taskSize = 10000;

        // 创建多个有返回值的任务  保存线程返回的结果
        List<Future> list = new ArrayList<Future>();

        for (int i = 0; i < taskSize; i++) {
            MyCallable c=new MyCallable(i+"");
            // 执行任务并获取Future对象
            Future f = pool.submit(c);
            // System.out.println(">>>" + f.get().toString());
            list.add(f);
        }
        pool.shutdown();
        for (Future f: list
             ) {
            System.out.println(f.get());

        }

        System.out.println("【"+(new Date().getTime()-beginTime.getTime())+"】ms");

    }


     static class  MyCallable implements  Callable<String>{
        String num;

        public MyCallable(String num) {
            this.num = num;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(100);
            System.out.println("花费【100】ms");
            return num+"次"+Thread.currentThread()+"";
        }

    }
}

