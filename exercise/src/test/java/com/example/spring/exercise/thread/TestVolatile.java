package com.example.spring.exercise.thread;

import org.junit.jupiter.api.Test;

/**
 * 测试线程同步synchronized.
 *
 * @author gy
 * @since 2021-7-2 15:57:06
 */
class TestVolatile {
  private volatile static boolean ready;
  private volatile static int number;

  @Test
  void test0() throws InterruptedException {
    System.out.println("主线程开始");
    //一个新的线程
    Thread anotherThread = new Thread(() -> {
      System.out.println("这是一个新线程");
      while(!ready) {
        Thread.yield();//退出线程
      }
      System.out.println(number);
    });
    anotherThread.start();
    number = 42;
    ready = true;

    //主线程main调用another线程的join()方法，就要等待another线程执行完毕，主线程才会继续往下执行
    anotherThread.join();
    System.out.println("主线程结束");
  }

}
