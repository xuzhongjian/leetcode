//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 1008 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private boolean[][] used;

    public int numIslands(char[][] grid) {
        used = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isIsLand(grid, i, j)) {
                    res++;
                }
            }
        }

        return res;
    }

    public boolean isIsLand(char[][] grid, int i, int j) {
        if (grid[i][j] != '0' && !used[i][j]) {
            markUsed(grid, i, j);
            return true;
        }
        return false;
    }

    public void markUsed(char[][] grid, int i, int j) {
        // 超过边界
        if (!isValidIndex(grid, i, j)) {
            return;
        }
        // 已经是海洋了 或者已经被标记使用了
        if (grid[i][j] == '0' || used[i][j]) {
            return;
        }
        // 是岛屿，需要被标记使用
        used[i][j] = true;
        markUsed(grid, i, j - 1);
        markUsed(grid, i, j + 1);
        markUsed(grid, i - 1, j);
        markUsed(grid, i + 1, j);
    }

    public boolean isValidIndex(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) {
            return false;
        }
        if (j < 0 || j >= grid[0].length) {
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
