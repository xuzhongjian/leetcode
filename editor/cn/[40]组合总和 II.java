//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 526 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        dfs(candidates, target, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, int index) {
        // 当数组走到头了之后
        if (index == candidates.length) {
            int sum = 0;
            ArrayList<Integer> oneRes = new ArrayList<>();
            for (int i = 0; i < candidates.length; i++) {
                // 把标记为选用的数字加起来
                if (used[i]) {
                    sum = sum + candidates[i];
                    oneRes.add(candidates[i]);
                }
            }
            // 如果标记为使用到的数字的和 与 目标相吻合 那么添加到答案集合中
            if (sum == target) {
                oneRes.sort((o1, o2) -> o1 - o2);
                if(!res.contains(oneRes)) {
                    res.add(oneRes);
                }
            }
            return;
        }

        // 不选用candidates[index]的数字
        dfs(candidates, target, index + 1);

        // 选用candidates[index]的数字
        used[index] = true;
        dfs(candidates, target, index + 1);
        used[index] = false;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
