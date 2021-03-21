//给定一个包含了一些 0 和 1 的非空二维数组 grid 。 
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 
//0（代表水）包围着。 
//
// 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。) 
//
// 
//
// 示例 1: 
//
// [
//   [0,0,1,0,0,0,0,1,0,0,0,0,0],
//   [0,0,0,0,0,0,0,1,1,1,0,0,0],
//   [0,1,1,0,1,0,0,0,0,0,0,0,0],
//   [0,1,0,0,1,1,0,0,1,0,1,0,0],
//   [0,1,0,0,1,1,0,0,1,1,1,0,0],
//   [0,0,0,0,0,0,0,0,0,0,1,0,0],
//   [0,0,0,0,0,0,0,1,1,1,0,0,0],
//   [0,0,0,0,0,0,0,1,1,0,0,0,0]
// ]
// 
//
// 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。 
//
// 示例 2: 
//
// [[0,0,0,0,0,0,0,0]] 
//
// 对于上面这个给定的矩阵, 返回 0。 
//
// 
//
// 注意: 给定的矩阵grid 的长度和宽度都不超过 50。 
// Related Topics 深度优先搜索 数组 
// 👍 451 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private boolean[][] used;

    public int maxAreaOfIsland(int[][] grid) {
        used = new boolean[grid.length][grid[0].length];
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int index1, int index2) {
        if (grid[index1][index2] == 0 || used[index1][index2]) {
            return 0;
        }
        used[index1][index2] = true;
        int up = index1 - 1 >= 0 ? dfs(grid, index1 - 1, index2) : 0;
        int down = index1 + 1 < grid.length ? dfs(grid, index1 + 1, index2) : 0;
        int left = index2 - 1 >= 0 ? dfs(grid, index1, index2 - 1) : 0;
        int right = index2 + 1 < grid[0].length ? dfs(grid, index1, index2 + 1) : 0;

        return 1 + up + down + right + left;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
