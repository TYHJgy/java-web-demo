package com.example.spring.exercise.redis;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class TestsRedis {

  @Autowired private StringRedisTemplate template; // = new StringRedisTemplate();

  @Test
  void contextLoads() {
    setKey("testRedis", "========value=========");
    System.out.println(getValue("testRedis"));
  }

  /**
   * 向redis中写入键值对
   *
   * @param key
   * @param value
   */
  public void setKey(String key, String value) {
    ValueOperations<String, String> ops = template.opsForValue();
    ops.set(key, value, 10, TimeUnit.MINUTES);
  }

  /**
   * 从redis中根据键取值
   *
   * @param key
   * @return
   */
  public String getValue(String key) {
    ValueOperations<String, String> ops = template.opsForValue();
    return ops.get(key);
  }
}
