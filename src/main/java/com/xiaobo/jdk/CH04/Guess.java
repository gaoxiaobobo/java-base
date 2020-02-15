package com.xiaobo.jdk.CH04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Guess {
    private  String name;
    public Guess(String name){
        this.name = name;
    }
    public static void main(String[] args) throws FileNotFoundException {
        double d = 2.3, d2 = 2.6;

//        Scanner console = new Scanner(System.in);
//        int number = (int) (Math.random() * 10);
//        int guess;
//♤ ♡ ♧ ♢
//        do {
//            System.out.print("猜數字（0 ~ 9）:");
//            guess = console.nextInt();
//        } while(guess != number);
        String[] arr = {"♤","♡","♧","♢"};
        String pathsrc = "src/main/java/com/xiaobo/jdk/CH04/test.txt";
        String pathtar = "src/main/java/com/xiaobo/jdk/CH04/test2.txt";
        System.setIn(new FileInputStream(pathsrc));
        try(Scanner s = new Scanner(System.in);
            PrintStream p = new PrintStream(new FileOutputStream(pathtar))) {
            while (s.hasNextLine()){
                System.out.println(s.nextLine());
            }
            System.setOut(p);
            System.out.println("good");
        }
    }
}