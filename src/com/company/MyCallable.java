package com.company;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * 4、使用ExecutorService、Callable、Future实现有返回结果的线程
 * Created by 梁峻磊 on 2017/8/18.
 */
public class MyCallable implements Callable<Object>{
    private String taskNum;

    public MyCallable(String taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(">>>" + taskNum + "任务启动");
        Date date1 = new Date();
        Thread.sleep(1000);
        Date date2 = new Date();
        long time = date2.getTime() - date1.getTime();
        System.out.println(">>>" + taskNum + "任务终止");
        return taskNum+"任务返回运行结果,当前任务时间【" + time + "毫秒】";
    }
}
