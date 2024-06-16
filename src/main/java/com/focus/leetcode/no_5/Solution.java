package com.focus.leetcode.no_5;

public class Solution {

    public static void main(String[] args) {
        String babad = new Solution().longestPalindrome("a");
        System.out.println(babad);
    }

    public String longestPalindrome(String s) {
        String maxStr = "";

        char[] chars = s.toCharArray();

        if (chars.length == 1) {
            return s;
        }

        for (int i = 0; i < chars.length -1; i++) {
            String compareStr = compare(i, chars);
            maxStr = maxStr.length() > compareStr.length() ? maxStr : compareStr;
        }

        return maxStr;
    }

    public String compare(int i, char[] chars){
        String str1 = execute(i, i, chars);
        String str2 = execute(i, i + 1, chars);

        return str1.length() > str2.length() ? str1 : str2;
    }


    public String execute(int i, int j, char[] chars){
        while (i >= 0 && j < chars.length && chars[i] == chars[j]) {
            i--;
            j++;
        }

        int length = j - i - 1;

        return new String(chars, ++i, length);
    }

}
