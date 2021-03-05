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

    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        // 初始化最左上角
        dp[0][0] = matrix[0][0] == '1' ? 1 : 0;
        // 初始化左边
        for (int i = 1; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] == '1'
                    ? dp[i - 1][0] + 1
                    : 0;
        }

        // 初始化上边
        for (int i = 1; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] == '1'
                    ? dp[0][i - 1] + 1
                    : 0;
        }

        /*
        for (int[] ints : dp) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        return 0;
        */

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i][j] = dpFunc(matrix, i, j);
            }
        }
        return dp[dp.length][dp[0].length];
    }

    public int dpFunc(char[][] matrix, int index1, int index2) {

        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
