package com.xiaobo.jdk;

import com.xiaobo.jdk.lambda.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.function.Function;

public class ArgsTest {

    static <K> K elemOf(K[] objs,int index){
        return objs[index];
    }
    static void modifyTheValue(int valueToBeOperated, Function<Integer, Integer> function) {
        int newValue = function.apply(valueToBeOperated);
        System.out.println(newValue);
    }

    public static void main(String args[]) {
//        try {
//            if (args.length == 0) {
//
//                throw new IllegalArgumentException("Give a file name");
//            }
//            System.out.println(System.getProperty("name"));
//            System.out.println(args[0]);
//
//        } catch (IllegalArgumentException e) {
//            System.err.println(e.getMessage());
//        }
        Student st = new Student("xx", 22);
//        System.out.println(st.customShow(s->s.name+": "+s.age));
//        String[] names = Arrays.asList("a","b");
//        String[] names = {"abbxxx", "bull", "ab2", "tiger"};
//        Arrays.sort(names, StringOrder::byLength);
//        System.out.println(Arrays.toString(names));
//        Deque a;
//
//        Arrays.sort(names, String::compareTo);
//        System.out.println(Arrays.toString(names));
//
//        int incr = 20;  int myNumber = 10;
//        modifyTheValue(myNumber, val-> val + incr);
//        String s = elemOf(names,1);



    }
}
