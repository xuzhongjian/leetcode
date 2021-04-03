//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 
// 👍 1299 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 表示，从前 i 户人家偷到的东西的价值最大是 dp[i]
     * 转移方程：
     * dp[i] = max(dp[i - 2] + nums[i], dp[i-1])
     * 其中的第一项表示偷当前这家的收益，因为偷了当前这家，robCur = cur - 2及之前的最大收益 + 当前这家的收益
     * 其中第二项表示，不偷当前这家的收益，因为不偷当前这家，所以可以偷前一家，notRobCur =  cur - 1及之前的最大收益
     */
    private int[] dp;

    public int rob(int[] nums) {
        switch (nums.length) {
            case 1:
                return nums[0];
            case 2:
                return Math.max(nums[0], nums[1]);
            default:
                break;
        }
        dp = new int[nums.length];
        this.buildDp(nums);
        return dp[dp.length - 1];
    }

    public void buildDp(int[] nums) {
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int robCur = dp[i - 2] + nums[i];
            int notRobCur = dp[i - 1];
            dp[i] = Math.max(robCur, notRobCur);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
