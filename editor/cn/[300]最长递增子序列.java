//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 二分查找 动态规划 
// 👍 1452 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * dp[i]: 以 nums[i] 结尾的这个子序列的最长递增子序列的长度
     * dp[i] = max(dp[m]) + 1 // m < i && nums[m] < nums[i]
     */
    private int[] dp;
    private int res;

    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length];
        fillDp(nums);
        return res;
    }

    public void fillDp(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 需要在 index == i 之前找比 target 小的位置
            int target = nums[i];
            int limit = Integer.MIN_VALUE;
            int temp = 0;
            for (int m = i - 1; m >= 0; m--) {
                if (limit < nums[m] && nums[m] < target) {
                    temp = Math.max(temp, dp[m]);
                    limit = nums[m];
                }
            }
            dp[i] = temp + 1;
            res = Math.max(res, dp[i]);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
