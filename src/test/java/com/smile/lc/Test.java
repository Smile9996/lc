package com.smile.lc;

public class Test {

    private final static String hh = "EEE";
    private String name;
    private int age;
    private String hobby;

    public Test() {
        //System.out.println("null");
    }

    public Test(String name, int age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        System.out.println("name:" + name + "\tage:" + age + "\thobby:" + hobby);
    }

    private Test(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("name:" + name + "\tage:" + age);
    }

    private void Hello(String name) {
        System.out.println("Hello, I am " + name);
    }
}
