//给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//
// 
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。 
// 
//
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace" ，它的长度为 3 。
// 
//
// 示例 2： 
//
// 
//输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc" ，它的长度为 3 。
// 
//
// 示例 3： 
//
// 
//输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 和 text2 仅由小写英文字符组成。 
// 
// Related Topics 动态规划 
// 👍 480 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * dp[i][j] 表示以字符串s1.[i]为结尾，以字符串s2.[j]为结尾的两个字符最长的公共字串的长度是 dp[i][j]
     * 转移方程：
     * dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j])  | s2.[j] != s1.[i]
     * dp[i][j] = dp[i - 1][j - 1]                      | s2.[j] != s1.[i]
     */
    public int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = ((i < 1 || j < 1) ? 0 : dp[i - 1][j - 1]) + 1;
                } else {
                    dp[i][j] = Math.max(j < 1 ? 0 : dp[i][j - 1], i < 1 ? 0 : dp[i - 1][j]);
                }
            }
        }
        return dp[s1.length() - 1][s2.length() - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
