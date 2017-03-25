package io.colorfire.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * @author colorfire on 17/3/22
 */
public class LongestPalindromicSubstring {

  public String longestPalindrome(String s) {
    if (s == null || s == "") return null;

    Map<Character, ArrayList<Integer>> map = new HashMap<>();
    String res = s.charAt(0) + "";

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        // 比对字符串, 如果是回文就放到结果集, 如果不是继续循环
        ArrayList<Integer> a = map.get(c);
        for (int ai : a) {
          String tmp = isPalindrome(s, ai, i);
          if (tmp.length() > res.length()) res = tmp;
        }

        a.add(i);
        map.put(c, a);
      } else {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(i);
        map.put(c, a);
      }

    }
    return res;
  }

  private String isPalindrome(String s, int start, int end) {
    for (int i = start, j = end; i < j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) return "";
    }
    return s.substring(start, end + 1); // TODO: substring api need plus one.
  }

  /**
   * second solution
   *
   * @param args
   */

  int low;
  int high;

  private String otherSolution(String s) {
    for (int i = 0; i < s.length(); i++) {
      isPalindromeTwo(s, i, i);
      isPalindromeTwo(s, i, i + 1);
    }
    return s.substring(low, high + 1);
  }


  private void isPalindromeTwo(String s, int i, int j) {
    while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
      i--;
      j++;
    }
    if ((j - i - 2) > (high - low)) {
      low = i + 1;
      high = j - 1;
    }
  }

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    System.out.println(new LongestPalindromicSubstring().longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    System.out.println("算法1执行时间: " + (System.currentTimeMillis() - startTime) + "ms");

    startTime = System.currentTimeMillis();
    System.out.println(new LongestPalindromicSubstring().otherSolution("babad"));
    System.out.println("算法2执行时间: " + (System.currentTimeMillis() - startTime) + "ms");

  }

}
