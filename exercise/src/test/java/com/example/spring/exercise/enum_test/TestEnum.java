package com.example.spring.exercise.enum_test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExerciseApplicationTestEnum {
    enum Color
    {
        RED, GREEN, BLUE;
    }

    @Test
    void contextLoads() {
        Color c1 = Color.BLUE;
        System.out.println(c1);
        System.out.println(Color2.BLUE);
    }

}

enum Color2
{
    RED, GREEN, BLUE;
}
