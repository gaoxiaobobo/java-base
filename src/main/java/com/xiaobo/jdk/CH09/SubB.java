package com.xiaobo.jdk.CH09;

import com.xiaobo.jdk.Base;

public class SubB extends Base {
    void showB(){
        System.out.println("i am subB");
    }
    SubB(){
//        System.out.println("b first");
//        super();
        System.out.println("调用　subB()");
    }


    public static void main(String[] arg) {
        System.out.println(arg[0]);
        SubB b = new SubB();
//        b.show();
//        Base base = new Base();
//        base.show();

    }
}
