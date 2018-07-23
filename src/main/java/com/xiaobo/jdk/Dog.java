package com.xiaobo.jdk;

public class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public Dog(Dog dog) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object clone() throws CloneNotSupportedException {
        return new Dog( this );
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Base base = new Base();
        base.show();
    }
}
