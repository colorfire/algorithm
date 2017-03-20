package io.colorfire.concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 参考: http://ifeve.com/java-special-troops-aqs/
 *
 * @author colorfire on 17/3/15
 */
public class CyclicBarrierTest {

  static CyclicBarrier lock = new CyclicBarrier(2);
  static ExecutorService serivce = Executors.newFixedThreadPool(10);

  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      serivce.execute(new Thread(new Runner(i, lock)));
    }
    serivce.shutdown();
  }


  static class Runner implements Runnable {

    private int num;
    CyclicBarrier lock;

    Runner(int num, CyclicBarrier lock) {
      this.num = num;
      this.lock = lock;
    }

    @Override
    public void run() {
      try {
        int timer = new Random().nextInt(5);
        Thread.sleep(timer);
        System.out.printf("%d 号选手,准备完毕. \n", num);
        lock.await();
        System.out.printf("%d 好选手出发。 \n", num);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (BrokenBarrierException e) {
        e.printStackTrace();
      }
    }
  }

}
