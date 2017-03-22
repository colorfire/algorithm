package io.colorfire.leetcode;


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

    Map<Character, Integer> map = new HashMap<>();
    String res = "";

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        // 比对字符串, 如果是回文就放到结果集, 如果不是继续循环
        String tmp = isPalindrome(s, map.get(c), i);
        if (tmp.length() > res.length()) res = tmp;
      } else {
        map.put(c, i);
      }

    }
    return res;
  }

  private String isPalindrome(String s, int start, int end) {
    for (int i = start, j = end; i < j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) return "";
    }
    return s.substring(start, end);
  }

  public static void main(String[] args) {
//    System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
    System.out.println("babad".substring(0,2));
  }

}
