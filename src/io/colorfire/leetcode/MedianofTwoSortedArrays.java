package io.colorfire.leetcode;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * TODO: NOT PASS
 *
 * @author colorfire on 17/3/22
 */
public class MedianofTwoSortedArrays {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {


    if (nums1.length == 0 && nums2.length > 0) {
      return nums2[nums2.length - 1];
    }

    if (nums2.length == 0 && nums1.length > 0) {
      return nums1[nums1.length - 1];
    }

    // 计算中值
    int mid = (nums1.length + nums2.length + 1) / 2;
    boolean flag = false;
    if ((nums1.length + nums2.length) % 2 != 0) {
      flag = true;
    }

    for (int i = 0, j = 0; i < Math.max(nums1.length, nums2.length); ) {
      if (i + j == mid - 1) {
        if (flag) {
          if (i == nums1.length) {
            return nums2[j];
          }

          if (j == nums2.length) {
            return nums1[i];
          }

          return Math.min(nums1[i], nums2[j]);
        } else {
          // 返回最小的两个数的平均值
          if (i + 1 < nums1.length && j + 1 < nums2.length)
            return min(nums1[i], nums1[i + 1], nums2[j], nums2[j + 1]);
          else if (i + 1 < nums1.length && j + 1 >= nums2.length) {
            if(j >= nums2.length) {
              return min(nums1[i], nums1[i + 1], 999, 999);
            }
            return min(nums1[i], nums1[i + 1], nums2[j], 999);
          } else if (i + 1 >= nums1.length && j + 1 < nums2.length) {
            if(i >= nums1.length) {
              return min(999, 999, nums2[j], nums2[j + 1]);
            }
            return min(nums1[i], 999, nums2[j], nums2[j + 1]);
          }
        }
      }

      if (i < nums1.length && j < nums2.length) {
        if (nums1[i] < nums2[j]) i++;
        else j++;
      } else if (i == nums1.length) {
        j++;
      } else if (j == nums2.length) {
        i++;
      }

    }
    return 0;
  }

  /**
   * 计算最小的两个值
   *
   * @param i1
   * @param i2
   * @param j1
   * @param j2
   * @return
   */
  private double min(int i1, int i2, int j1, int j2) {
    if (i2 < j1) {
      return (i1 + i2) / 2; // i,j队列有序
    }

    if (j2 < i1) {
      return (j1 + j2) / 2;
    }

    return (double) (i1 + j1) / 2;
  }

  public static void main(String[] args) {
    System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4}));
  }
}