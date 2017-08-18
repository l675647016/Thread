package com.company;

/**
 * 2、实现Runnable接口创建线程
 * Created by 梁峻磊 on 2017/8/18.
 */
public class MyThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println("MyThread2");
    }
}
