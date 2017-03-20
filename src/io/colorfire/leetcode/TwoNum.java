package io.colorfire.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author colorfire on 17/3/13
 */
public class TwoNum {

  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    int[] res = new int[2];
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        res[1] = i;
        res[0] = map.get(target - nums[i]);
        return res;
      }

      map.put(nums[i], i);
    }
    return res;
  }

  public static void main(String[] args) {
    int[] arg = {2, 7, 11, 15};
    System.out.println(TwoNum.twoSum(arg, 9));
  }

}
