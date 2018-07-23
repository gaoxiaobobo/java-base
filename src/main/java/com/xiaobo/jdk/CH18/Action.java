package com.xiaobo.jdk.CH18;

public enum Action {
    STOP(0) ,
    RIGHT(3),
    LEFT(2) ,
    UP(3) ,
    DOWN(4);

    private int value;
    private Action(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
