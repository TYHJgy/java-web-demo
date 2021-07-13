package com.example.spring.exercise.interface_test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExerciseApplicationTestInterface {
    @Test
    void contextLoads() {
        TestInterface testInterface = new TestInterface();
        testInterface.setHomeTeam();
        testInterface.setHomeTeam2();
        testInterface.setHomeTeam3();
    }

}

class TestInterface implements Hockey,Football {

    @Override
    public void setHomeTeam() {
        System.out.println("this is setHomeTeam");
    }

    @Override
    public void setHomeTeam2() {
        System.out.println("this is setHomeTeam2");

    }

    @Override
    public void setHomeTeam3() {
        System.out.println("this is setHomeTeam3");

    }
}
// 文件名: Sports.java
interface Sports
{
    public void setHomeTeam();
}

// 文件名: Football.java
interface Football extends Sports
{
    public void setHomeTeam2();
}

// 文件名: Hockey.java
interface Hockey extends Sports
{
    public void setHomeTeam3();
}