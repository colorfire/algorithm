package io.colorfire.leetcode;

import com.sun.tools.javac.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * @author colorfire on 17/3/22
 */
public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {

    int maxLength = 0;
    int len = 0;
    Map<Character, Integer> map = new HashMap<>();

    for (int j = 0; j < s.length(); j++) {
      for (int i = j; i < s.length(); i++) {
        char c = s.charAt(i);
        if (map.containsKey(c)) {
          break;
        } else {
          len++;
          if (len > maxLength) {
            maxLength = len;
          }
          map.put(c, i);
        }
      }
      len = 0;
      map = new HashMap<>();
    }
    return maxLength;
  }

  public int bestSolution(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int maxLength = 0;

    for (int i = 0, j = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        j = Math.max(j, map.get(c) + 1);
      }
      maxLength = Math.max(maxLength, i - j + 1);
      map.put(c, i);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    int res = new LongestSubstringWithoutRepeatingCharacters().bestSolution("pwwkew");
    System.out.println(res);
  }
}
