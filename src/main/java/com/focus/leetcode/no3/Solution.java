package com.focus.leetcode.no3;

public class Solution {
    public static void main(String[] args) {
        int pwwkew = new Solution().lengthOfLongestSubstring(" ");
        System.out.println(pwwkew);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        }

        String[] strings = s.split("");

        String subStr = "";
        int maxLength = 0;
        for (int i = 0; i < strings.length; i++) {
            String ss = strings[i];

            if (!subStr.contains(ss)) {
                subStr = subStr + ss;
            } else {
                maxLength = Math.max(maxLength, subStr.length());

                int index = subStr.indexOf(ss);

                subStr = (subStr + ss).substring(index + 1);
            }
        }
        return Math.max(maxLength, subStr.length());
    }
}
