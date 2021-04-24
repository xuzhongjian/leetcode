//给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是 2 。 
//
// 
//
// 示例： 
//
// 
//输入：[4, 6, 7, 7]
//输出：[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]
//] 
//
// 
//
// 提示： 
//
// 
// 给定数组的长度不会超过15。 
// 数组中的整数范围是 [-100,100]。 
// 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。 
// 
// Related Topics 深度优先搜索 
// 👍 277 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> tempList = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> resiii = new ArrayList<>(tempList);
            if (resiii.size() >= 2 && !res.contains(resiii)) {
                res.add(resiii);
            }
            return;
        }

        int lastValue = tempList.size() != 0 ? tempList.peekLast() : -200;

        // 不选择当前这位
        dfs(nums, index + 1);

        // 选择当前这位
        if (nums[index] >= lastValue) {
            tempList.addLast(nums[index]);
            dfs(nums, index + 1);
            tempList.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
