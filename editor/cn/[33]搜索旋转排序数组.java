//升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
// 
//
// 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 6
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// nums 肯定会在某个点上旋转 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 二分查找 
// 👍 1104 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            int o = nums[l];
            int p = nums[mid];
            int q = nums[r];

            if (p == target) {
                return mid;
            }
            // mid 在前半部分
            if (o <= p) {
                // o < target < p
                if (o <= target && target < p) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            // mid 在后半部分
            else {
                // p < target <= q
                if (p < target && target <= q) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
