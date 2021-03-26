//给你一个 无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。 
//
// 示例 3： 
//
// 
//输入：intervals = [], newInterval = [5,7]
//输出：[[5,7]]
// 
//
// 示例 4： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,3]
//输出：[[1,5]]
// 
//
// 示例 5： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,7]
//输出：[[1,7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= intervals[i][0] <= intervals[i][1] <= 105 
// intervals 根据 intervals[i][0] 按 升序 排列 
// newInterval.length == 2 
// 0 <= newInterval[0] <= newInterval[1] <= 105 
// 
// Related Topics 排序 数组 
// 👍 384 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        int begin = newInterval[0];
        int end = newInterval[1];
        int beginIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= begin && begin <= interval[1]) {
                beginIndex = i;
            }
            if (interval[0] <= end && end <= interval[1]) {
                endIndex = i;
            }
        }
        System.out.println(beginIndex + " " + endIndex);

        int[][] res = new int[intervals.length - (endIndex - beginIndex)][2];
        for (int i = 0; i < beginIndex; i++) {
            res[i] = intervals[i];
        }
        for (int i = 0; i < intervals.length - endIndex; i++) {
            res[res.length - 1 - i] = intervals[intervals.length - 1 - i];
        }

        if (beginIndex != -1 && endIndex != -1) {
            res[beginIndex] = new int[]{intervals[beginIndex][0], intervals[endIndex][1]};
        } else if (endIndex == -1) {
            res[beginIndex] = new int[]{intervals[beginIndex][0], newInterval[1]};
        } else if (beginIndex == -1) {
            res[beginIndex] = new int[]{newInterval[0], intervals[endIndex][1]};
        }

        System.out.println(res[beginIndex][0] + " " + res[beginIndex][1]);

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
