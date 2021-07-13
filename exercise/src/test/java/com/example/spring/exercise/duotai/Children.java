package com.example.spring.exercise.duotai;

public class Children implements Parent,Parent2 {

    @Override
    public void getName(){
        System.out.println("我是C1");
    }

    @Override
    public void getYear() {
        System.out.println("C1年龄：18");
    }

    @Override
    public void getName2() {
        System.out.println("我是C2");
    }

    @Override
    public void getYear2() {
        System.out.println("C2年龄：17");
    }
    public void getHeight(){
        System.out.println("C1身高：180");
    }
}
