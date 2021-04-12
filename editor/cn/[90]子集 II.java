//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
// 
// 
// 
// Related Topics 数组 回溯算法 
// 👍 556 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private LinkedList<Integer> tempList = new LinkedList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int index) {
        if (index == nums.length) {
            ArrayList<Integer> resTemp = new ArrayList<>(tempList);
            resTemp.sort((o1, o2) -> o1 - o2);
            if (!res.contains(resTemp)) {
                res.add(resTemp);
            }
            return;
        }

        // 不选择当前项
        dfs(nums, index + 1);

        // 选择当前项
        tempList.addLast(nums[index]);
        dfs(nums, index + 1);
        tempList.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
