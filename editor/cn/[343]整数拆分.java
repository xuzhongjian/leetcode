//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。 
//
// 示例 1: 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。

// 6
// 3 + 3
//
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。 
// Related Topics 数学 动态规划 
// 👍 487 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int temp = 0;
            for (int j = 1; j < i; j++) {
                // 是用dp的结果还是直接使用
                // 如果 i = 8, j = 3, i - j = 5, max 第二项表示将 5 拆分的结果
                // 第一项表示直接用 5 的结果
                // 8 = 3 + 5 这个计算就是 3 * ( 5 or a * b * c ...)
                // a + b + c = 5
                temp = Math.max(temp, j * Math.max(i - j, dp[i - j]));
            }
            dp[i] = temp;
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
