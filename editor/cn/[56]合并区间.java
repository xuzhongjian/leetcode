//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 821 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        LinkedList<List<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(intervals[i][0]);
            temp.add(intervals[i][1]);
            lists.add(temp);
        }

        LinkedList<List<Integer>> result = new LinkedList<>();

        List<Integer> target = lists.pollFirst();
        while (lists.size() > 0) {
            List<Integer> e = lists.pollFirst();

            if (couldMerge(target, e)) {
                target = Arrays.asList(Math.min(target.get(0), e.get(0)), Math.max(target.get(1), e.get(1)));
            } else {
                result.add(target);
                target = e;
            }
        }
        result.add(target);
        int size = result.size();
        int[][] ints = new int[size][2];
        for (int i = 0; i < result.size(); i++) {
            ints[i][0] = result.get(i).get(0);
            ints[i][1] = result.get(i).get(1);
        }
        return ints;
    }

    public boolean couldMerge(List<Integer> target, List<Integer> e) {
        if (target.get(0) <= e.get(0) && e.get(0) <= target.get(1)) {
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
