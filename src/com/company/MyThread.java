package com.company;

/**
 * 1、继承Thread类创建线程
 * Created by 梁峻磊 on 2017/8/18.
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("MyThread!!!");
    }
}
