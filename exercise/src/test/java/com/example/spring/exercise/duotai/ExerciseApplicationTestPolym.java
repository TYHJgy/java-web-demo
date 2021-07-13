package com.example.spring.exercise.duotai;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExerciseApplicationTestPolym {
    @Test
    void contextLoads() {
        System.out.println(ExerciseApplicationTestPolym.class+"----"+"123");
    }

    /*
    * 多态测试
    * 多态存在的三个必要条件：
    * 1.继承
    * 2.重写
    * 3.父类引用指向子类对象：Parent p = new Child();
    * */
    @Test
    void testPolym(){
        Parent parent  = new Children();
        parent.getName();
        parent.getYear();

        Children children  = new Children();
        children.getName();
        children.getYear();
        children.getHeight();

        Children2 children2 = new Children2();
        children2.getName3();
        children2.getYear3();
        children2.getHeight();
        System.out.println();
        System.out.println(children);
    }
}
