package io.colorfire.concurrent;

/**
 * @author colorfire on 17/2/26
 */
public class RandomThreadTest extends Thread {

  private int threadNo;

  public RandomThreadTest(int threadNo) {
    this.threadNo = threadNo;
  }

  public static void main(String[] args) throws Exception {
    for (int i = 0; i < 10; i++) {
      new RandomThreadTest(i).start();
    }
  }

  @Override
  public synchronized void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("I am " + threadNo + " thread");
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
