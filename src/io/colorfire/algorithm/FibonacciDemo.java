package io.colorfire.algorithm;

/**
 * @author colorfire on 17/3/11
 * @TODO(weigangqiu): 斐波那契螺旋线的实现
 */
public class FibonacciDemo {


  /**
   * 递归迭代
   *
   * @param n
   * @return
   */
  public static int recursFibonacci(int n) {
    if (n <= 2) return 1;
    else
      return recursFibonacci(n - 1) + recursFibonacci(n - 2);
  }

  /**
   * 递推实现
   *
   * @param n
   * @return
   */
  public static int nonrecursFibonacci(int n) {
    if (n <= 2) return 1;

    int n1 = 1, n2 = 1, sn = 0;
    for (int i = 0; i < n - 2; i++) {
      sn = n1 + n2;
      n1 = n2;
      n2 = sn;
      System.out.print(sn + "\t");
      if ((i + 2) % 5 == 0)
        System.out.println();
    }

    return sn;
  }

  /**
   * @param n
   * @return
   */
  public static int arrayFibonacci(int n) {
    int arr[] = new int[n];

    arr[0] = arr[1] = 1;
    for (int i = 2; i < arr.length; i++) {
      arr[i] = arr[i - 1] + arr[i - 2];
    }

    return arr[n - 1];
  }

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    System.out.println(new FibonacciDemo().recursFibonacci(20));
    System.out.println("递归实现fibonacci执行时间: " + (System.currentTimeMillis() - startTime) + "ms");

    startTime = System.currentTimeMillis();
    System.out.println(new FibonacciDemo().nonrecursFibonacci(20));
    System.out.println("递推实现fibonacci执行时间: " + (System.currentTimeMillis() - startTime) + "ms");

    System.out.println(new FibonacciDemo().arrayFibonacci(20));
  }

}