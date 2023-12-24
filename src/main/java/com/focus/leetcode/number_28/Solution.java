package com.focus.leetcode.number_28;


/**
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/submissions/
 */
public class Solution {

    public int strStr(String haystack, String needle) {
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();
        for (int i = 0; i <= chars1.length - chars2.length; i++) {
            int j;
            for (j = 0; j < chars2.length; j++) {
                if (chars2[j] !=  chars1[i+j]) {
                    break;
                }
            }

            if (j == chars2.length) {
                return i;
            }
        }

        return -1;
    }

    public int strStr1(String haystack, String needle) {

        if (!haystack.contains(needle)) {
            return -1;
        }

        String[] strs = haystack.split(needle);

        if (strs.length == 0) {
            return 0;
        }

        return strs[0].length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("asdssadbutsad", "sad"));
    }

}
