//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针 
// 👍 800 👎 0


import java.util.HashMap;
import java.util.Objects;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> timesMap = new HashMap<>();
        for (int num : nums) {
            if (timesMap.containsKey(num)) {
                timesMap.put(num, timesMap.get(num) + 1);
            } else {
                timesMap.put(num, 1);
            }
        }
        int index = 0;
        for (int i = 0; i <= 2; i++) {
            Integer times = timesMap.get(i);
            if (Objects.nonNull(times)) {
                for (int j = 0; j < times; j++) {
                    nums[index] = i;
                    index++;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
