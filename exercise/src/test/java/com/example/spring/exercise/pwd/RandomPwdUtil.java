package com.example.spring.exercise.pwd;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 随机生成密码。密码包含大写、小写、特殊字符。生成密码时可设置密码长度（8-20位）.
 *
 * @author gaoyang@richinfo.cn
 * @version 1.0.0
 * @date 2021-4-1 17:33:01
 */
class RandomPwdUtil {

  /** 特殊字符字符串. */
  private static final String SPECIAL_CHARACTER_STR = "~!@#$%^&*()_+/-=[]{};:'<>?.";
  private static final String lowStr = "abcdefghijklmnopqrstuvwxyz";
  private static final String numStr = "0123456789";

  /**
   * 随机获取字符串字符.
   *
   * @param str 字符串
   * @return 字符串中随机一个字符
   */
  private static char getRandomChar(String str) {
    SecureRandom random = new SecureRandom();
    return str.charAt(random.nextInt(str.length()));
  }

  /**
   * 指定调用字符函数.
   *
   * @param funNum 类型
   * @return 字符函数
   */
  private static char getRandomChar(int funNum) {
    switch (funNum) {
      case 0:
        return getLowChar();
      case 1:
        return getUpperChar();
      case 2:
        return getNumChar();
      default:
        return getSpecialChar();
    }
  }

  /**
   * 随机获取小写字符.
   *
   * @return 获取小写字符
   */
  private static char getLowChar() {
    return getRandomChar(lowStr);
  }

  /**
   * 随机获取数字字符.
   *
   * @return 数字字符
   */
  private static char getNumChar() {
    return getRandomChar(numStr);
  }

  /**
   * 随机获取特殊字符.
   *
   * @return 特殊字符
   */
  private static char getSpecialChar() {
    return getRandomChar(SPECIAL_CHARACTER_STR);
  }

  /**
   * 随机获取大写字符.
   *
   * @return 大写字符
   */
  private static char getUpperChar() {
    return Character.toUpperCase(getLowChar());
  }

  /**
   * 随机生成密码.
   *
   * @param num 指定密码长度
   * @return 密码
   */
  static String getRandomPwd(int num) {
    if (num > 20 || num < 8) {
      return "";
    }
    List<Character> list = new ArrayList<>(num);
    list.add(getLowChar());
    list.add(getUpperChar());
    list.add(getNumChar());
    list.add(getSpecialChar());

    for (int i = 4; i < num; i++) {
      SecureRandom random = new SecureRandom();
      int funNum = random.nextInt(4);
      list.add(getRandomChar(funNum));
    }

    Collections.shuffle(list); // 打乱排序
    StringBuilder stringBuilder = new StringBuilder(list.size());
    for (Character c : list) {
      stringBuilder.append(c);
    }

    return stringBuilder.toString();
  }
}
