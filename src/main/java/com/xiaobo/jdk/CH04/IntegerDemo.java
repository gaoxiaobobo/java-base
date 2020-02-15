package com.xiaobo.jdk.CH04;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.xiaobo.jdk.StringOrder;

import java.util.*;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class IntegerDemo {

    public int[] arrSort(int[] d) {
        int tmp = 0;
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d.length - 1 - j; j++) {
                if (d[j] <= d[j + 1]) {
                    tmp = d[j];
                    d[j] = d[j + 1];
                    d[j + 1] = tmp;

                }
                System.out.println("i:" + i + "\t," + j + Arrays.toString(d));
            }
            System.out.println("i am i:" + i);
            tmp = i;


        }
        System.out.println("end " + tmp);
//        System.out.println("i am i+1:"+i);
        return d;
    }

    public void testLoop() {
        Set<Character> vos = new HashSet<>();
        String test = "AABCDBCA";
        char[] charArr= test.toCharArray();
        for (int i = 0; i < charArr.length ; i++) {
            vos.add(charArr[i]);
        }
        System.out.println(vos.toString());
//        for (Character s : vos) {
//            System.out.println(s);
//        }

    }

    public static void main(String[] args) {
        IntegerDemo demo = new IntegerDemo();

        String s = "abcabcbb";
        int[] d = {1, 2, 3, 4};
        demo.testLoop();
//        System.out.println(Arrays.toString(d));
    }
}
