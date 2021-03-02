//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意：答案中不可以包含重复的四元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [], target = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 哈希表 双指针 
// 👍 759 👎 0


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<Integer>> fourSum(int[] numsArray, int target) {
        List<Integer> nums = new ArrayList<>();
        for (Integer num : numsArray) {
            nums.add(num);
        }

        List<Integer> subRes = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, 4, subRes, res, target);
        HashSet<List<Integer>> set = new HashSet<>();
        for (List<Integer> list : res) {
            list.sort((o1, o2) -> o1 - o2);
            set.add(list);
        }

        return set.stream().collect(Collectors.toList());
    }

    /**
     * @param nums   数据底
     * @param i      当前的index
     * @param length 目标长度
     * @param subRes 单个答案
     * @param res    整体答案
     */
    public void dfs(List<Integer> nums, int i, int length, List<Integer> subRes, List<List<Integer>> res, int target) {
        if (i == nums.size()) {
            if (subRes.size() == length) {
                if (sumCollection(subRes) == target) {
                    res.add(new ArrayList<>(subRes));
                }
            }
            return;
        }
        // 不选择当前
        dfs(nums, i + 1, length, subRes, res, target);

        // 选择当前
        subRes.add(nums.get(i));
        dfs(nums, i + 1, length, subRes, res, target);
        subRes.remove(subRes.size() - 1);
    }

    public int sumCollection(List<Integer> nums) {
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
