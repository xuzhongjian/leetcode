//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3369 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        // isValid[i][j] = true 表示 字符串s的[i,j]是一个回文字符串
        boolean[][] isValid = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    isValid[i][j] = true;
                } else if (j == i + 1) {
                    isValid[i][j] = s.charAt(i) == s.charAt(j);
                }
            }
        }

        for (int subLength = 2; subLength < s.length(); subLength++) {
            for (int start = 0; start < s.length() - subLength; start++) {
                int end = start + subLength;
                isValid[start][end] = isValid[start + 1][end - 1] && s.charAt(start) == s.charAt(end);
            }
        }

        int resI = 0;
        int resJ = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isValid[i][j]) {
                    if (resJ - resI < j - i) {
                        resI = i;
                        resJ = j;
                    }
                }
            }
        }
        return s.substring(resI, resJ + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
