package com.xiaobo.jdk;

public class FinalForm {
//    public final int a ;
    public static final int a = 3;

//    public FinalForm(int a) {
//        this.a = a;
//    }
}


class FinalTest{
    public static void main(String[] args) {
        FinalForm t1  = new FinalForm();
        System.out.println(t1.a);
        FinalForm t2  = new FinalForm();
        System.out.println(t2.a);
    }

}