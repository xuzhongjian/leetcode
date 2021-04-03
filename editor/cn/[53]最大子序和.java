//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：nums = [-100000]
//输出：-100000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 3015 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * dp[i]表示：以 nums[i] 结尾的连续子数组最大的和是 dp[i]
     * 转移方程：
     * dp[i] = max(dp[i - 1] + nums[i], nums[i])
     * 第一项表示，nums[i] 要成为前面的连续子数组的下一位，拼接到原来的连续子数组之后的新的连续子数组的和是 dp[i - 1] + nums[i]
     * 第二项表示，nums[i] 是一个新的连续子数组的第一位，当然也只有一位，这个崭新的连续子数组的和就是 nums[i]
     * dp[i] 取这两项中的较大值
     */
    private int[] dp;
    private int res;

    public int maxSubArray(int[] nums) {
        dp = new int[nums.length];
        fullDp(nums);
        return res;
    }

    public void fullDp(int[] nums) {
        dp[0] = nums[0];
        res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
