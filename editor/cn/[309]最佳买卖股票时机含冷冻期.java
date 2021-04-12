//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 716 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int[][] dp = new int[prices.length][3];

        dp[0][0] = 0; // noting
        dp[0][1] = -prices[0]; // 持有股票
        dp[0][2] = 0; // 出手股票

        for (int i = 1; i < prices.length; i++) {
            // nothing 第二项 昨天出手或者不出手
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            // 持有 或者 购入->从 do nothing那天转化过来
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 出手
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
