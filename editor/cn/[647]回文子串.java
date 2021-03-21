//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 514 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
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

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isValid[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
