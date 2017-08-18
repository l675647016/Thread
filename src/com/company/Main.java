package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	//第一种Thread
	    MyThread myThread1 = new MyThread();
	    MyThread myThread2 = new MyThread();
	    myThread1.start();
	    myThread2.start();

	    //第二种Thread
	    MyThread2 myThread21 = new MyThread2();
	    MyThread2 myThread22 = new MyThread2();
	    myThread21.run();
	    myThread22.run();

	    //第三种Thread
		Callable callable = new MyThread3();
		//由Callable创建一个FutureTask对象
		//注释：FutureTask<Integer>是一个包装器，它通过接受Callable<Integer>来创建，它同时实现了Future和Runnable接口。
		FutureTask futureTask = new FutureTask(callable);
		//由FutureTask创建一个Thread对象
		Thread thread = new Thread(futureTask);
		thread.start();

		//第四种Thread
		System.out.println("----程序开始运行----");
		Date date1 = new Date();
		int taskSize = 5;
		//创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		//创建有多个返回值的任务
		List<Future> list = new ArrayList<Future>();
		for (int i = 0;i < taskSize;i++){
			//获取Callable对象
			Callable callable1 = new MyCallable(i + " ");
			//执行任务并获取Future对象
			/*
			ExecutoreService提供了submit()方法，传递一个Callable，或Runnable，返回Future。
			如果Executor后台线程池还没有完成Callable的计算，这调用返回Future对象的get()方法，会阻塞直到计算完成。
			*/
			Future future = pool.submit(callable1);
			list.add(future);
		}
		//关闭线程池
		pool.shutdown();
		//获取所有并发任务执行的结果
		for (Future f:list) {
			// 从Future对象上获取任务的返回值，并输出到控制台
			System.out.println(">>>" + f.get().toString());
		}

		Date date2 = new Date();
		System.out.println("----程序结束运行----，程序运行时间【"
				+ (date2.getTime() - date1.getTime()) + "毫秒】");
	}
}
