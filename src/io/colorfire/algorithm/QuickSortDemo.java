package io.colorfire.algorithm;

/**
 * 基于分治的思想，是冒泡排序的改进型。首先在数组中选择一个基准点（该基准点的选取可能影响快速排序的效率，后面讲解选取的方法），
 * 然后分别从数组的两端扫描数组，设两个指示标志（lo指向起始位置，hi指向末尾)，首先从后半部分开始，如果发现有元素比该基准点的值小，
 * 就交换lo和hi位置的值，然后从前半部分开始扫秒，发现有元素大于基准点的值，就交换lo和hi位置的值，如此往复循环，
 * 直到lo>=hi,然后把基准点的值放到hi这个位置。一次排序就完成了。以后采用递归的方式分别对前半部分和后半部分排序，
 * 当前半部分和后半部分均有序时该数组就自然有序了。
 *
 * 参考: http://blog.csdn.net/jianyuerensheng/article/details/51258374
 *
 * @author colorfire on 17/3/18
 */
public class QuickSortDemo {


  public void sort(int[] a, int low, int hight) {
    int i, j, index;
    if (low > hight) {
      return;
    }
    i = low;
    j = hight;
    index = a[i]; // 用子表的第一个记录做基准

    while (i < j) { // 从表的两端交替向中间扫描
      while (i < j && a[j] >= index) // 从右边扫描
        j--;
      if (i < j)
        a[i++] = a[j];// 用比基准小的记录替换低位记录
      while (i < j && a[i] < index) // 从左边扫描
        i++;
      if (i < j) // 用比基准大的记录替换高位记录
        a[j--] = a[i];
    }
    a[i] = index;// 将基准数值替换回 a[i]
    sort(a, low, i - 1); // 对低子表进行递归排序
    sort(a, i + 1, hight); // 对高子表进行递归排序
  }

  public static void main(String[] args) {
    int[] a = {12, 20, 5, 16, 15, 1, 30, 45, 23, 9};
    new QuickSortDemo().sort(a, 0, 9);

    System.out.println(a);
  }

}
