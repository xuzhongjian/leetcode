//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1025 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> subRes = new LinkedList<>();

        dfs(nums, 0, res, subRes);

        return res;
    }

    public void dfs(int[] nums, int index, List<List<Integer>> res, LinkedList<Integer> subRes) {
        if (index == nums.length) {
            res.add(new ArrayList<>(subRes));
            return;
        }

        // 不选择 index 对应的当前位置
        dfs(nums, index + 1, res, subRes);

        // 选择当前位置
        subRes.addLast(nums[index]);
        dfs(nums, index + 1, res, subRes);
        subRes.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
