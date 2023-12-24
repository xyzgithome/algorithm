package com.focus.leetcode.number_28;

public class StrStrLeetcode28KMP {
    public int strStr(String haystack, String needle) {
        char[] origin = haystack.toCharArray();
        char[] pattern = needle.toCharArray();

        int[] lsp = lsp(pattern);

        /*
        1. 匹配成功，i++ j++, 直到j==模式字符串长度
        2. 匹配失败
            j != 0 跳过最长前后缀字符，继续匹配
            j == 0 则i++
         */
        int i = 0;
        int j = 0;
        while (pattern.length - j <= origin.length - i) {
            if (origin[i] == pattern[j]) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = lsp[j - 1];
            }

            if (j == pattern.length) {
                // 找到解
                return i - j;
            }
        }

        return -1;
    }

    /**
     * 最长前后缀数组：只跟模式字符串相关
     * 1. 索引：使用了模式字符串前j个字符串 -1
     * 2. 值：最长前后缀的长度（恰好是j要跳转的位置）
     *
     * @param pattern
     * @return
     */
    private int[] lsp(char[] pattern) {
        return new int[]{0, 0, 1, 2, 3, 0, 1};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("ababababcabacacababaca", "ababaca"));

        StrStrLeetcode28KMP kmp = new StrStrLeetcode28KMP();
        System.out.println(kmp.strStr("ababababcabacacababaca", "ababaca"));
    }
}
