//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 动态规划 
// 👍 689 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[][] dp;

    public int maximalSquare(char[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0] == '1' ? 1 : 0;
        int max = dp[0][0];
        for (int i = 1; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(max, dp[i][0]);
        }

        // 初始化上边
        for (int i = 1; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            max = Math.max(max, dp[0][i]);
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                max = Math.max(max, dpFunc(matrix, i, j));
            }
        }
        return max * max;
    }

    public int dpFunc(char[][] matrix, int index1, int index2) {
        if (matrix[index1][index2] == '1') {
            dp[index1][index2] = Math.min(dp[index1 - 1][index2 - 1], Math.min(dp[index1 - 1][index2], dp[index1][index2 - 1])) + 1;
            if (index1 + 1 < dp[index1][index2] || index2 + 1 < dp[index1][index2]) {
                dp[index1][index2] = Math.min(index1 + 1, index2 + 1);
            }
        } else {
            dp[index1][index2] = 0;
        }
        return dp[index1][index2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
