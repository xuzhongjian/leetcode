//给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如
//同俄罗斯套娃一样。 
//
// 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 说明: 
//不允许旋转信封。 
//
// 示例: 
//
// 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出: 3 
//解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
// 
// Related Topics 二分查找 动态规划 
// 👍 387 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEnvelopes(int[][] matrix) {
        // 宽度不等时 宽度升序 相等时长度降序
        Arrays.sort(matrix, (o1, o2) -> (o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]));
        // ends 数组是用 记录 长度为 index + 1 最小的结尾
        int[] ends = new int[matrix.length];
        ends[0] = matrix[0][1];
        // 用二分效率高
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < matrix.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (matrix[i][1] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = matrix[i][1];
        }
        return right + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
