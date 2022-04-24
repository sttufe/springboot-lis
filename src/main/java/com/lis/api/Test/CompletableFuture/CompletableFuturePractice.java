package com.lis.api.Test.CompletableFuture;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFuturePractice {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(10);//线程池，一般放在静态成员变量中
      
       /* CompletableFuture<Integer> exceptionally = CompletableFuture.supplyAsync(() -> {
            //返回一个数据
            return 1;
        },executorService).whenComplete((res, throwable) -> {
            //完成异步时获取返回值
            System.out.println("返回值是："+res+",异常是："+throwable);
        }).exceptionally((throwable) -> {
            //接收异常，修改返回值
            System.out.println("获得到的异常是:"+throwable);
            return 10;//返回一个值替代原来的返回值
        });*/




      /*  //多任务并发同步完成
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务一开始");
            return 1;
        },executorService);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务二开始");
            return 2;
        },executorService);
        future1.runAfterBothAsync(future2,()->{
            System.out.println("联合任务1和2");
        },executorService);*/



       /* CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务一开始");
            return 1;
        },executorService);
        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务二开始");
            return 2;
        },executorService);
        future3.thenAcceptBothAsync(future4,(result1,result2)->{
            System.out.print("感知任务一和任务二完成，执行任务三");
            System.out.println("future"+Thread.currentThread().getName());
        },executorService);
        System.out.println("主线程"+Thread.currentThread().getName());*/


        //前两个人任务完成过后，执行第三个任务。
        CompletableFuture<Integer> future5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务一开始");
            return 1;
        },executorService);
        CompletableFuture<Integer> future6 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务二开始");
            return 2;
        });
        future5.thenCombineAsync(future6,(res1,res2)->{
            System.out.println("感知任务完成，合并两个任务，返回一个新的结果"+res1+res2);
            return res1+","+res2;
        },executorService);
        System.out.println(Thread.currentThread().getName());



        CompletableFuture<Integer> future7 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务一开始");
            return 1;
        },executorService);
        CompletableFuture<Integer> future8 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务二开始");
            return 2;
        });
        CompletableFuture<Integer> future9 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务三开始");
            return 3;
        }, executorService);

        CompletableFuture<Void> allOf = CompletableFuture.allOf(future7, future8, future9);
        try {
            allOf.get();//等待所有任务都完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
