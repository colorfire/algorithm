package io.colorfire.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author colorfire on 17/3/15
 */
public class CountDownLatchTest {

  static CountDownLatch count = new CountDownLatch(4);
  static ExecutorService service = Executors.newFixedThreadPool(10);

  public static void main(String[] args) throws InterruptedException {

    for (int i = 0; i < 4; i++) {
      service.execute(() -> {
        try {
          int timer = new Random().nextInt(5);
          Thread.sleep(timer);
          count.countDown();

          System.out.println(Thread.currentThread().getName() + ", 磁盘空间计算完毕。");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });
    }

    count.await();
    System.out.println("所有线程计算完毕");
  }
}
