package com.example.spring.exercise.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/**
 * 通过 Callable 和 Future 创建线程
 */
class CallableThread implements Callable<Integer> {
  public static void main(String[] args) {
    CallableThread ctt = new CallableThread();
    FutureTask<Integer> ft = new FutureTask<>(ctt);
    for (int i = 0; i < 100; i++) {
      System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
      if (i == 20) {
        new Thread(ft, "有返回值的线程").start();
      }
    }
    try {
      System.out.println("子线程的返回值：" + ft.get());
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Integer call() {
    int i = 0;
    for (; i < 100; i++) {
      System.out.println(Thread.currentThread().getName() + " " + i);
    }
    return i;
  }
}
