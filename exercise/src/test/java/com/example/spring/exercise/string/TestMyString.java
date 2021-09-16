package com.example.spring.exercise.string;

import java.util.Date;
import org.apache.kafka.common.protocol.types.Field.Str;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class TestMyString {
  //字符串常用方法


  //字符串转整数
  @Test
  void testStrToInt(){
    String str = "123";
//    int a = Integer.parseInt(str);
    long a2 = Long.parseLong(str);
    System.out.println(a2);
  }

  //反转字符串
  @Test
  void testReverse(){
    StringBuffer strb = new StringBuffer();
    strb.append("abcdefg");
    System.out.println(strb.reverse());
  }

  //字符串转换为时间
  @Test
  void testStrToDate(){
    Date date = new Date();//"2020-10-01";
    String str = String.format("yyyy-MM-dd", date);
    System.out.println(date);

  }

  @Test
  void testHash(){
    String str = "132";

    System.out.println(str.indexOf('2'));
    System.out.println(str.hashCode());
  }

  @Test
  void contextLoads() {
    System.out.println(TestMyString.class + "----" + "123");
  }

  // 创建字符串
  // String 创建的字符串存储在公共池中，而 new 创建的字符串对象在堆上：
  @Test
  void createStr() {
    String s1 = "Runoob"; // String 直接创建
    String s2 = "Runoob"; // String 直接创建
    String s4 = new String("Runoob"); // String 对象创建
    String s5 = new String("Runoob"); // String 对象创建
    String s6 = new String(s5); // String 对象创建
    System.out.println(s1 == s2);
    System.out.println(s4 == s5);
    System.out.println(s5 == s6);
    System.out.println(s6);
  }


  // 连接字符串
  @Test
  void connectStr() {
    String string1 = "菜鸟教程网址：";
    System.out.println("1、" + string1 + "www.runoob.com");
  }

  // 创建格式化字符串
  @Test
  void formatStr() {
    System.out.printf(
        "浮点型变量的值为 " + "%f, 整型变量的值为 " + " %d, 字符串变量的值为 " + "is %s", 1.5, 25, "stringVar");
    String fs;
    fs =
        String.format(
            "浮点型变量的值为 " + "%f, 整型变量的值为 " + " %d, 字符串变量的值为 " + " %s", 1.5, 25, "stringVar");
  }

  // 常用方法
  @Test
  void commonMethod() {
    String string = "abcdefghijk";
    String string2 = "abcd";
    String string3 = new String("abcd");
    string.length();
    int i = string.codePointCount(0, 1);
    System.out.println(i);

    System.out.println(string == string2);
    System.out.println(string == string3);
    System.out.println(string.equals(string3));
    System.out.println(string.hashCode());
    System.out.println(string3.hashCode());
  }
}
