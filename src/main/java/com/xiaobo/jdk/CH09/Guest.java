package com.xiaobo.jdk.CH09;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.lang.System.out;

public class Guest {
    public static void main(String[] args) {
//        List names = new java.util.ArrayList();
//        collectNameTo(names);
//        out.println("訪客名單：");
//        printUpperCase(names);

//        List<String> names = Arrays.asList( new String[]{"abbxxx", "bull", "ab2", "tiger"});
//        names = new ArrayList<>(names);
//        names.forEach(out::println);
//        out.println("======");
//        names.add(0,"hello1");
//        names.add("hello2");
//        names.forEach(out::println);

//        Predicate<Integer> func = x -> x > 1;
//        System.out.println("是否大于1? " + func.test(2));
//
//        Consumer<Integer> funcC = x -> System.out.println(x);
//        funcC.accept(2);
        test1();



    }
    public static void test1(){
        //消费100，洗澡
        consumerMonkey(100,(m) -> System.out.println("洗澡花费了100元"));
        //消费200，吃饭
        consumerMonkey(200,(m) -> System.out.printf("吃饭花费了　%f",m));
        out.println();
    }

    /**
     *  消费monkey，但是没有指定出使用什么方式消费
     * */
    public static void consumerMonkey(double money, Consumer<Double> policy){
        policy.accept(money);
    }

    static void collectNameTo(List names) {
        Scanner console = new Scanner(System.in);
        while (true) {
            out.print("訪客名稱：");
            String name = console.nextLine();
            if (name.equals("quit")) {
                break;
            }
            names.add(name);
        }
    }

    static void printUpperCase(List names) {
        for (int i = 0; i < names.size(); i++) {
            String name = (String) names.get(i);
            out.println(name.toUpperCase());
        }
    }
}