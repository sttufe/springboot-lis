package com.lis.api.Contrller;

import com.lis.api.Test.AsynTaskFature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Controller
@RequestMapping("/")
public class InNumberController {




    @Autowired
    AsynTaskFature taskService;


    @RequestMapping(value="/test",method = RequestMethod.GET)
    @ResponseBody
    public long test(HttpServletResponse response) throws InterruptedException, ExecutionException {

        long s = System.currentTimeMillis();
		Future<String> task1 = taskService.task1();
		Future<String> task2 = taskService.task2();
        Future<String> task3 = taskService.task3();
        for (;;) {
            // 回调函数 Future 如果执行完毕就会返回这个函数
            if (task3.isDone()) {
                //System.out.println("task1");
                break;
            }
        }
		System.out.println(task1.get());
		System.out.println(task2.get());
        System.out.println(task3.get());


        long e = System.currentTimeMillis();
        System.out.println("task总耗时:" + (e - s));

        return  (e - s);
    }
}

