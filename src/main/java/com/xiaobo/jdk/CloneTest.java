package com.xiaobo.jdk;

import java.util.ArrayList;
import java.util.List;

public class CloneTest {
    public static void main(String a[]){
        List<Dog> d1 = new ArrayList<Dog>();
        d1.add(new Dog("xx"));
        List<Dog> d2 =cloneList(d1);
        d2.get(0).setName("xx2");
        System.out.println(d1);
        System.out.println(d2);


    }
    public static List<Dog> cloneList(List<Dog> list) {
        List<Dog> clone = new ArrayList<Dog>(list.size());
        for (Dog item : list)
            try {
                clone.add((Dog) item.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        return clone;
    }
}

