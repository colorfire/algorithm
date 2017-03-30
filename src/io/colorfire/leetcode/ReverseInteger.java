package io.colorfire.leetcode;

/**
 * Reverse digits of an integer.
 * @TODO int的取值范围为（-2147483648~2147483647），占用4个字节（-2的31次方到2的31次方-1）
 *
 * @author colorfire on 17/3/30
 */
public class ReverseInteger {

  public int reverse(int x) {
    System.out.println(x / 1000);
    return 0;
  }


  public static void main(String[] args) {
    System.out.println(new ReverseInteger().reverse(123));
  }
}
