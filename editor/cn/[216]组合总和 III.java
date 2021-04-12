//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法 
// 👍 289 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> tempList = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int size, int targetSum) {
        dfs(size, targetSum, 1);
        return res;
    }

    public void dfs(int size, int targetSum, int iter) {
        if (targetSum == 0 && tempList.size() == size) {
            res.add(new ArrayList<>(tempList));
            return;
        } else if (targetSum < 0) {
            return;
        } else if (iter == 10) {
            return;
        }

        // 选用当前的iter
        tempList.addLast(iter);
        dfs(size, targetSum - iter, iter + 1);
        tempList.removeLast();

        // 不选用当前的iter
        dfs(size, targetSum, iter + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
