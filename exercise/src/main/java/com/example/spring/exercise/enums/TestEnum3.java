package com.example.spring.exercise.enums;

public enum TestEnum3 implements BaseEnum {
    RED, GREEN, BLUE;
    private String name;
    private String val;
    @Override
    public String getName() {

        return name;
    }
    @Override
    public String getVal() {

        return val;
    }
}