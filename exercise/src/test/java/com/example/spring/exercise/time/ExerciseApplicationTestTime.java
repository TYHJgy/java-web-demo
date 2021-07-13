package com.example.spring.exercise.time;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class ExerciseApplicationTestTime {

    //获取时间
    @Test
    void contextLoads() {
        // 初始化 Date 对象
        Date date = new Date();
        // 使用 toString() 函数显示日期时间（格式Wed Dec 30 14:19:23 CST 2020）
        System.out.println(date.toString());

        //日期格式化
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        System.out.println("当前时间为: " + ft.format(date));
    }

}
