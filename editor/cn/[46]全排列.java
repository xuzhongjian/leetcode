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
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num)
        }

    }

    public void subPermute(Set<Integer> set, List<Integer> pre) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)
