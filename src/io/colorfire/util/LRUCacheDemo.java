package io.colorfire.util;

import java.util.Hashtable;

/**
 * LRU(Least recently used)最少使用的被淘汰
 * 由于采用链表设计, 其时间复杂度为O(1)
 *
 * @author colorfire on 17/3/10
 */
public class LRUCacheDemo {

  private int cacheSize;
  private Hashtable nodes;//缓存容器
  private int currentSize;
  private Node first;//链表头
   private Node last;//链表尾

   /**
   * 工具链
   */
  class Node {
    Node prev;
    Node next;
    Object val;
    Object key;

    Node() {
    }
  }

  public LRUCacheDemo(int size) {
    this.cacheSize = size;
    this.currentSize = 0;
    nodes = new Hashtable(size);
  }

  public Object get(Object key) {
    Node node = (Node) nodes.get(key);
    if (node != null) {
      move2Head(node);
      return node.val;
    }
    return null;
  }

  public void put(Object key, Object val) {
    Node node = (Node) nodes.get(key);
    if (node == null) {
      if (currentSize >= cacheSize) {
        if (last != null)
          nodes.remove(last.key);
        removeLast();
      } else {
        currentSize++;
      }
      node = new Node();
    }
    node.key = key;
    node.val = val;
    move2Head(node);
    nodes.put(key, node);
  }

  /**
   * 移除最后一个
   */
  private void removeLast() {
    if (last != null) {
      if (last.prev != null)
        last.prev.next = null;
      else
        first = null;
      last = last.prev;
    }
  }


  private void move2Head(Node node) {
    if (node == first) {
      return;
    }

    if (node == last) {
      last = node.prev;
    }

    // 将原有node拿出来, 重新指定node, 把当前node指向链的第一个。
    if (node.prev != null) {
      node.prev.next = node.next;
    }
    if (node.next != null) {
      node.next.prev = node.prev;
    }

    if (first != null) {
      node.next = first;
      first.prev = node;
    }

    node.prev = null;
    first = node;

    if (last == null) {
      last = node; // 如果链表为空,则last初始化为当前node
    }
  }

  /**
   * 测试用例:
   * 某缓存系统采用LRU淘汰算法，假定缓存容量为4,并且初始为空，那么在顺序访问一下数据项的时候：1,5,1,3,5,2,4,1,2出现缓存直接命中的次数是？，最后缓存中即将准备淘汰的数据项是？
   * 因此，直接命中次数是3,最后缓存即将准备淘汰的数据项是5
   *
   * @param args
   */
  public static void main(String args[]) {
    int size = 5;
    int[] array = {1, 5, 1, 3, 5, 2, 4, 1, 2};
    LRUCacheDemo test = new LRUCacheDemo(size);
    for (int i = 0; i < array.length; i++) {
      test.put(i, array[i]);
    }
    System.out.println(test.last.val);
  }

}
