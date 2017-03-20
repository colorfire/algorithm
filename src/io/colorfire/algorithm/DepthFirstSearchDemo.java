package io.colorfire.algorithm;

import java.util.Stack;

/**
 * @TODO(weigangqiu):
 * @author colorfire on 17/3/11
 */
public class DepthFirstSearchDemo {

  static class Leaf {
    private int val;
    private Leaf left;
    private Leaf right;
    private Leaf parent;
  }

  private Leaf root = new Leaf();

  /**
   * 非递归实现二叉树
   *
   * @param array
   */
  public void initTree(int[] array) {
    Leaf current = root;
    for (int i = 0; i < array.length; i++) {
      Leaf node = new Leaf();
      node.val = array[i];
      node.parent = current;

      if (current.left == null) {
        current.left = node;
        continue;

      } else if(current.right == null) {
        current.right = node;
      }

      current = node;
    }
  }

  /**
   * 打印二叉树
   */
  public void printTree(Leaf node) {
    if (node == null) return;
    System.out.println(node.val);
    printTree(node.left);
    printTree(node.right);
  }


  public void formatTree() {
    Stack<Leaf> stack = new Stack<>();
    stack.push(root);

    while(!stack.isEmpty()) {
      Leaf current = stack.pop();

      System.out.println(current.val);

      if(current.left != null) {
        stack.push(current.left);
      }

      if(current.right != null) {
        stack.push(current.right);
      }
    }

  }

  public static void main(String[] args) {
    int[] str = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    DepthFirstSearchDemo demo = new DepthFirstSearchDemo();
    demo.initTree(str);
    demo.formatTree();
  }

}
