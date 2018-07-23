package com.xiaobo.jdk.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * 参考网址
 * https://www.mkyong.com/java8/java-8-foreach-examples/
 */
public class SortPeople {
    public static void main(String[] args) {
//        Predicate p;
        Person[] people = {new Person("gxb", 33),
                new Person("zxl", 34),
                new Person("xy", 32)};
//        sort(people);
//        sortDes(people);

        List<Person> l = asList(new Person("holi",12),
                new Person("paopao",7),
                new Person("bb",3));
        List<Person> filterL = l.stream().filter(p-> p.getAge()>3).collect(Collectors.toList());
        l.forEach(p-> System.out.println(p));

        filterL.forEach(System.out::println);


    }
    static void sort(Person[] people){
        Comparator<Person> byName = Comparator.comparing(p -> p.getName());
        Arrays.sort(people, byName);
        for (Person p : people) {
            System.out.println(p);
        }
        System.out.println("--------");

//        方法引用
        Comparator<Person> byAge = Comparator.comparing(Person::getAge);
        Arrays.sort(people,byAge);

        asList(people).forEach(System.out::println);
    }

    static void sortDes(Person[] people){
        System.out.println("desc --------");
        Comparator<Person> byName = Comparator.comparing(Person::getName).reversed();
        Arrays.sort(people,byName);
        asList(people).forEach(item-> System.out.println(item));

    }

}
