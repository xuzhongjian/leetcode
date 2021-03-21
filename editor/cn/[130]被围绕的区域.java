//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [
//          ["X","X","X","X"],
//          ["X","O","O","X"],
//          ["X","X","O","X"],
//          ["X","O","X","X"]
//       ]
//
//输出：[
//          ["X","X","X","X"],
//          ["X","X","X","X"],
//          ["X","X","X","X"],
//          ["X","O","X","X"]
//       ]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 492 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 从边界出发，标记所有不符合变换标准的位置为 "#"
                if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        // 当数组越界的时候
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }

        board[i][j] = '#';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
