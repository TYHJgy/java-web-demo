package com.example.spring.exercise.testLambda;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

/**
 * 测试java Lambda表达式.
 *
 * @author gy
 * @since 2021-7-6
 */
class TestLambda {

  @Test
  void testLam (){

    // 类型声明
    MathOperation addition = Integer::sum;

    // 不用类型声明
    MathOperation subtraction = (a, b) -> a - b;

    // 大括号中的返回语句
    MathOperation multiplication = (int a, int b) -> a * b;

    // 没有大括号及返回语句
    MathOperation division = (int a, int b) -> a / b;

    System.out.println("100 + 15 = " + operate(100, 15, addition));
    System.out.println("100 - 50 = " + operate(100, 50, subtraction));
    System.out.println("110 x 45 = " + operate(110, 45, multiplication));
    System.out.println("120 / 55 = " + operate(120, 55, division));

    // 不用括号
    GreetingService greetService1 = message ->
        System.out.println("Hello " + message);

    // 用括号
    GreetingService greetService2 = (message) ->
        System.out.println("Hello " + message);

    greetService1.sayMessage("Runoob");
    greetService2.sayMessage("Google");
  }

  interface MathOperation {
    int operation(int a, int b);
  }

  interface GreetingService {
    void sayMessage(String message);
  }

  private int operate(int a, int b, @NotNull("mathOperation不可为null") MathOperation mathOperation){
    return mathOperation.operation(a, b);
  }
}


