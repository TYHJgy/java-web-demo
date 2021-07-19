package com.example.spring.exercise.pwd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestPwd {

  @Test
  void test(){
    for(int i = 0;i<10;i++){
      String randomPwd = RandomPwdUtil.getRandomPwd(10);
      System.out.println(randomPwd);
    }
  }

}
