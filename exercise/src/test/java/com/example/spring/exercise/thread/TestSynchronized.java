package com.example.spring.exercise.thread;

import org.junit.jupiter.api.Test;

/**
 * 测试线程同步synchronized.
 *
 * @author gy
 * @since 2021-7-2 15:57:06
 */
class TestSynchronized {
  private int account = 0;

  public int getAccount() {
    return account;
  }


  /**
   * 未用同步方法实现
   *
   * @param money
   */
  public void save0(int money) {
    account += money;
  }


  /**
   * 用同步方法实现
   *
   * @param money
   */
  public synchronized void save(int money) {
    account += money;
  }

  /**
   * 用同步代码块实现
   *
   * @param money
   */
  public void save1(int money) {
    synchronized (this) {
      account += money;
    }
  }


  @Test
  void test0() throws InterruptedException {
    TestSynchronized testSynchronized = new TestSynchronized();
    System.out.println("主线程开始");
    //一个新的线程
    Thread anotherThread = new Thread(() -> {
      System.out.println("这是一个新线程");
      for(int i = 0;i<100000;i++){
        testSynchronized.save0(1);

      }
      System.out.println("新线程account="+ testSynchronized.getAccount());
    });
    anotherThread.start();
    for(int i = 0;i<100000;i++){
      testSynchronized.save0(1);
    }
    System.out.println("主线程account="+ testSynchronized.getAccount());

    //主线程main调用another线程的join()方法，就要等待another线程执行完毕，主线程才会继续往下执行
    anotherThread.join();
    System.out.println("主线程结束");
  }

  @Test
  void test1() throws InterruptedException {
    TestSynchronized testSynchronized = new TestSynchronized();
    System.out.println("主线程开始");
    //一个新的线程
    Thread anotherThread = new Thread(() -> {
      System.out.println("这是一个新线程");
      for(int i = 0;i<100000;i++){
        testSynchronized.save(1);

      }
      System.out.println("新线程account="+ testSynchronized.getAccount());
    });
    anotherThread.start();
    for(int i = 0;i<100000;i++){
      testSynchronized.save(1);
    }
    System.out.println("主线程account="+ testSynchronized.getAccount());

    //主线程main调用another线程的join()方法，就要等待another线程执行完毕，主线程才会继续往下执行
    anotherThread.join();
    System.out.println("主线程结束");
  }

  @Test
  void test2() throws InterruptedException {
    TestSynchronized testSynchronized = new TestSynchronized();
    System.out.println("主线程开始");
    //一个新的线程
    Thread anotherThread = new Thread(() -> {
      System.out.println("这是一个新线程");
      for(int i = 0;i<100000;i++){
        testSynchronized.save1(1);

      }
      System.out.println("新线程account="+ testSynchronized.getAccount());
    });
    anotherThread.start();
    for(int i = 0;i<100000;i++){
      testSynchronized.save1(1);
    }
    System.out.println("主线程account="+ testSynchronized.getAccount());

    //主线程main调用another线程的join()方法，就要等待another线程执行完毕，主线程才会继续往下执行
    anotherThread.join();
    System.out.println("主线程结束");
  }



}
