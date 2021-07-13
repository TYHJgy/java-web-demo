package com.example.spring.exercise.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestException {
  @Test
  void test() {
    int a[] = new int[2];
    System.out.println("Access element three :" + a[3]);
  }

  void test(int i) {
    if (i == 0) {
      return;
    } else {
      test(i++);
    }
  }

  // 递归 造error.
  @Test
  void test1() {
    test(5);
  }

  // 捕获test()异常。
  @Test
  void test2() {
    try {
      test();
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println(e);
    }
    System.out.println("Out of the block");
  }

  @Test
  void test3() throws Exception {
    String nStr = null; // = "0";
    if (nStr == null) {
      // 用trow关键字抛出异常，当异常被抛出时，程序会跳出该方法
      // throw new Exception("输入的字符不能为空！");
      System.out.println("test3");
    }
    throw new Exception("输入的字符不能为空！");
  }

  // 捕获test3抛出的异常
  @Test
  void test4() {
    try {
      test3();
    } catch (Exception e) {
      System.out.println(e);
      // throw new NullPointerException("输入的字符不能为空！");
    }
  }
}
