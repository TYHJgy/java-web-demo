package com.example.spring.exercise.generics;

import org.apache.kafka.common.protocol.types.Field.Str;
import org.junit.jupiter.api.Test;

class GenericTest {

  /**
   * 测试泛型类
   */
  @Test
  void test1() {
    // 泛型的类型参数只能是类类型（包括自定义类），不能是简单类型.
    // 传入的实参类型需与泛型的类型参数类型相同，即为Integer.
    Generic<Integer> genericInteger = new Generic<>(123456);

    // 传入的实参类型需与泛型的类型参数类型相同，即为String.
    Generic<String> genericString = new Generic<>("key_vlaue");
    System.out.println("泛型测试:key is " + genericInteger.getKey());
    System.out.println("泛型测试:key is " + genericString.getKey());
  }

  /** 测试通配符. */
  @Test
  void test2() {
    Generic<Integer> gInteger = new Generic<>(123);
    Generic<Number> gNumber = new Generic<>(456);

    showKeyValue(gInteger);
    showKeyValue(gNumber);
  }

  /**
   * 通配符.
   *
   * @param obj 对象.
   */
  private void showKeyValue(Generic<?> obj) {
    System.out.println("泛型测试:key value is " + obj.getKey());
  }

  /**
   * 测试泛型方法.
   */
  @Test
  void test3() {

    String str = genericMethod("abc");
    System.out.println("测试泛型方法:"+ str);
    Integer i = genericMethod(123);
    System.out.println("测试泛型方法:"+ i);
    genericMethod2(456);

  }

  @Test
  void test4() throws IllegalAccessException, InstantiationException {
    String str2 = String.class.newInstance();
    Integer j = Integer.class.newInstance();
  }

  /**
   * 泛型方法的基本介绍
   * @param tClass 传入的泛型实参
   * @return T 返回值为T类型
   * 说明：
   *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
   *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
   *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
   *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
   */
  private <T> T genericMethod(T tClass) {
    return tClass;
  }
  private <T> void genericMethod2(T tClass) {
    System.out.println("测试泛型方法:"+ tClass);
  }


}
