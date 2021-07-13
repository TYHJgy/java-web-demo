package com.example.spring.exercise.enums;

public enum TestEnum2 {
    RED("gy","18"), GREEN("gy","18"), BLUE("gy","18");
    private String name;
    private String year;

    public String getName() {
        return name;
    }
    public void setName(String gy) {
        this.name = gy;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    TestEnum2(String name, String year)
    {
        this.name = name;
        this.year = year;
    }
}