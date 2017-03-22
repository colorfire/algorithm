package io.colorfire.algorithm;

/**
 *
 * 翻转一个链表
 *
 * @author colorfire on 17/3/21
 */
public class ReverseListDemo {

  static class Node {
    Node next;
    int val;
  }

  private Node reverse(Node node) {
    Node newNode = null;
    Node current = node;

    while(current != null) {
      Node next = current.next;
      current.next = newNode;
      newNode = current;
      current = next;
    }

    return newNode;
  }

  public static void main(String[] args) {
    Node node = new Node();
    node.val = 0;
    node.next = new Node();
  }

}
