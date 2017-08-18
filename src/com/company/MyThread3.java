package com.company;

import java.util.concurrent.Callable;

/**
 * 3、实现Callable接口通过FutureTask包装器来创建Thread线程
 * Created by 梁峻磊 on 2017/8/18.
 */
public class MyThread3 implements Callable{
    @Override
    public Object call() throws Exception {
        System.out.println("MyThread3");
        return null;
    }
}
