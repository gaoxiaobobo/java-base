package com.xiaobo.jdk.CH11.Thread;

public class DaemonDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");

        Thread thread = new Thread(() -> {
            int start = 0;
            while (true) {

                System.out.printf("%d %n",start++);
            }
        });
        System.out.println("middle");
        thread.setDaemon(true);
        thread.start();

        Thread.sleep(1);
        System.out.println("end®");
    }
}
