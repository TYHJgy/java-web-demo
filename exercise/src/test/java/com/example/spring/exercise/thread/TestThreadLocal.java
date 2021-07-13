package com.example.spring.exercise.thread;


/**
 * 测试ThreadLocal.
 * ThreadLocal中填充的变量只属于当前线程，该变量对其他线程而言是隔离的，是当前线程独有的变量.
 * 常用方法get、set、remove
 */
public class TestThreadLocal {
  //定义一个存储线程id的threadLocal副本
  private ThreadLocal<Long> threadId = new ThreadLocal<>();
  //定义一个存储线程name的threadLocal副本
  private ThreadLocal<String> threadName = new ThreadLocal<>();

  public static void main(String[] args) throws InterruptedException {
    final TestThreadLocal test = new TestThreadLocal();
    //main线程
    test.threadId.set(Thread.currentThread().getId());
    test.threadName.set(Thread.currentThread().getName());

    System.out.println("main线程的id：" + test.threadId.get());
    System.out.println("main线程的Name:" + test.threadName.get());

    //一个新的线程
    Thread anotherThread = new Thread(() -> {
      test.threadId.set(Thread.currentThread().getId());
      test.threadName.set(Thread.currentThread().getName());

      System.out.println("another线程的id："+ test.threadId.get());
      System.out.println("another线程的Name:" + test.threadName.get());
    });

    anotherThread.start();
    //主线程main调用another线程的join()方法，就要等待another线程执行完毕，主线程才会继续往下执行
    anotherThread.join();

    System.out.println("main线程的id：" + test.threadId.get());
    System.out.println("main线程的Name:" + test.threadName.get());

    /*移除线程本地变量*/
    test.threadId.remove();
    test.threadName.remove();
  }

}
