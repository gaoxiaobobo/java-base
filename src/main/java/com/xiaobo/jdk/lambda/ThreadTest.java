package com.xiaobo.jdk.lambda;


public class ThreadTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {// 接口名
            @Override
            public void run() {// 方法名
                System.out.println("Thread run1()");
            }
        }).start();
        System.out.println("我是主线程");
        new Thread(new Runnable() {// 接口名
            @Override
            public void run() {// 方法名
                System.out.println("Thread run2()");
            }
        }).start();
        new Thread(
                () -> System.out.println("Thread lambda1 run()")// 省略接口名和方法名
        ).start();
        new Thread(
                () -> {//两行要加{}和分号
                    System.out.println("Thread lambda run()");
                    System.out.println("thread 2 lines");
                }
        ).start();
        new Thread(() -> System.out.println("xx")).start();
    }
}
