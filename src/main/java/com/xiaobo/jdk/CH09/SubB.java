package com.xiaobo.jdk.CH09;

import com.xiaobo.jdk.Base;

public class SubB extends Base {
    void showB(){
        System.out.println("i am subB");
    }

    public static void main(String[] args) {
        SubB b = new SubB();
//        b.show();
        Base base = new Base();
//        base.show();

    }
}
