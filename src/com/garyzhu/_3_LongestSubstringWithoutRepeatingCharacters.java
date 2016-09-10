package com.garyzhu;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p/>
 * Examples:
 * <p/>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p/>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p/>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p/>
 * Subscribe to see which companies asked this question
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> helper = new HashSet<>();
        helper.add(s.charAt(0));
        int count = 1, maxCount = 1;
        for (int i = 0; i < s.length(); i++) {
            if (helper.contains(s.charAt(i))) {
                helper.clear();
                helper.add(s.charAt(i));
                if (count > maxCount) {
                    maxCount = count;
                }
                count = 1;
            } else {
                helper.add(s.charAt(i));
                count++;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
    }
}
