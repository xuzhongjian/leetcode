//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划 
// 👍 1107 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int dp[] = new int[s.length()];
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else if (s.charAt(i - 1) == '(') {
                dp[i] = (i - 2 < 0 ? 0 : dp[i - 2]) + 1;
            } else {
                int length = dp[i - 1] * 2;
                int prevIndex = i - length - 1;
                int pprevIndex = prevIndex - 1;
                int addtion = pprevIndex < 0 ? 0 : dp[pprevIndex];
                dp[i] = prevIndex < 0
                        ? 0
                        : (s.charAt(prevIndex) == '(' ? dp[i - 1] + 1 + addtion : 0);
            }
        }
        int ans = 0;
        for (int i : dp) {
            ans = ans > i ? ans : i;
        }
        return ans * 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
