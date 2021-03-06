package io.colorfire.leetcode;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 *
 * @author colorfire on 17/3/16
 */
public class AddTwoNumbers {

  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode c1 = l1;
    ListNode c2 = l2;
    ListNode sentinel = new ListNode(0);
    ListNode d = sentinel;
    int sum = 0;
    while (c1 != null || c2 != null) {
      sum /= 10;
      if (c1 != null) {
        sum += c1.val;
        c1 = c1.next;
      }
      if (c2 != null) {
        sum += c2.val;
        c2 = c2.next;
      }
      d.next = new ListNode(sum % 10);
      d = d.next;
    }
    if (sum / 10 == 1)
      d.next = new ListNode(1);
    return sentinel.next;
  }


  public static void main(String[] args) {
    ListNode l1 = new ListNode(5);

    ListNode l2 = new ListNode(5);

    ListNode res = new AddTwoNumbers().addTwoNumbers(l1, l2);
    System.out.printf("%d, %d, ", res.val, res.next.val);
  }
}
