//给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。 
//
// 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 提示：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1、s2、和 s3 都由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 419 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * dp[i][j] 表示使用 s1[0] 到 s1[i - 1] 中间的字符 和 s2[0] 到 s1[j - 1] 中间的字符
     * 可批匹配到的到 s3[0] - s3[dp[i][j] -1]
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() < s1.length() + s2.length()) {
            return false;
        }

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        dp[0][0] = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s3.charAt(i)) {
                dp[i + 1][0] = i + 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == s3.charAt(i)) {
                dp[0][i + 1] = i + 1;
            } else {
                break;
            }
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (dp[i - 1][j] == 0 && dp[i][j - 1] == 0) {
                    dp[i][j] = 0;
                }
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    int index = dp[i - 1][j];
                    if (s3.charAt(index) == s1.charAt(i - 1)) {
                        dp[i][j] = index + 1;
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    int index = dp[i][j - 1];
                    if (s3.charAt(index) == s2.charAt(j - 1)) {
                        dp[i][j] = index + 1;
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()] == s3.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
