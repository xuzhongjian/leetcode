//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1096 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private Set<List<Integer>> result = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> tempList = new ArrayList<>();
        this.subCombinationSum(candidates, target, tempList);
        List<List<Integer>> collect = result.stream().collect(Collectors.toList());
        return collect;
    }

    public void subCombinationSum(int[] candidates, int target, List<Integer> tempList) {
        for (int candidate : candidates) {
            if (candidate > target) {
                continue;
            } else if (candidate < target) {
                List<Integer> list = new ArrayList<>(tempList);
                list.add(candidate);
                this.subCombinationSum(candidates, target - candidate, list);
            } else {
                List<Integer> list = new ArrayList<>(tempList);
                list.add(candidate);
                list.sort((o1, o2) -> {
                    return o1 - o2;
                });
                result.add(list);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
