//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 525 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> tempList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 0);
        return res;
    }

    // 范围是 [1,n]
    // 取 k 个数字
    // 目前到了第 index 个 : from 0
    private void dfs(int n, int k, int index) {
        if (tempList.size() == k) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        if (index == n) {
            return;
        }

        // 不取当前这个
        dfs(n, k, index + 1);

        // 取当前这个
        tempList.add(index + 1);
        dfs(n, k, index + 1);
        tempList.remove(tempList.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
