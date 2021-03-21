//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1044 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> tempList = new ArrayList<>();
    private boolean[] visited;
    private int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        visited = new boolean[nums.length];

        dfs();

        return res;
    }

    public void dfs() {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                tempList.add(nums[i]);
                visited[i] = true;
                dfs();
                visited[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
