package io.colorfire.algorithm;

/**
 * 通过链表方式实现Hashmap, 最新的jdk1.8使用的是红黑树
 * 参考: http://blog.csdn.net/kimylrong/article/details/21654405
 *
 * @author colorfire on 17/3/11
 */
public class HashMapDemo<K, V> {

  private int capacity;
  private int size;

  private Node<K, V>[] buckets;


  public HashMapDemo(int capacitySize) {

  }

  public void put(K key, V value) {
    int position = index(key);

    Node<K, V> node = buckets[position];

    while(node != null) {
      if (node.key.equals(key)) {
        node.value = value;
        return;
      }
      node = node.next;
    }

    Node<K, V> newNode = new Node<>(key, value);
    if (buckets[position] != null) {
      newNode.setNext(buckets[position]);
    }

    buckets[position] = newNode;
    size++;
  }

  public V get(K key) {
    int position = index(key);
    Node<K, V> node = buckets[position];

    while (node != null) {
      if (node.key.equals(key)) {
        return node.value;
      }

      node = node.next;
    }

    return null;
  }


  private static double A = (Math.pow(5, 0.5) - 1) / 2;

  /**
   * hash算法
   *
   * @param key
   * @return
   */
  private int index(K key) {
    int hashCode = key.hashCode();

    double temp = hashCode * A;
    double digit = temp - Math.floor(temp);

    return (int) Math.floor(digit * capacity);
  }


  /**
   * 自定义节点
   *
   * @param <K>
   * @param <V>
   */
  static class Node<K, V> {
    private final K key;
    private V value;
    private Node<K, V> next;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
    }

    public V getValue() {
      return value;
    }

    public void setValue(V value) {
      this.value = value;
    }

    public Node<K, V> getNext() {
      return next;
    }

    public void setNext(Node<K, V> next) {
      this.next = next;
    }

    public K getKey() {
      return key;
    }
  }

}
