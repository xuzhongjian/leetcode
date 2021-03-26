//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [
// [1, 2, 3, 4],
// [5, 6, 7, 8],
// [9,10,11,12]
// ]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 626 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> res = new ArrayList<Integer>();
    int matrixSize = 0;

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int up = 0;
        int right = matrix[0].length - 1;
        int down = matrix.length - 1;
        int left = 0;
        matrixSize = (right + 1) * (down + 1);
        while (true) {
            if (add(matrix, up++, left, right, true)) break;
            if (add(matrix, right--, up, down, false)) break;
            if (add(matrix, down--, right, left, true)) break;
            if (add(matrix, left++, down, up, false)) break;
        }
        return res;
    }

    // 是不是满了
    public boolean add(int[][] matrix, int index, int from, int to, boolean isHang) {
        while (from != to) {
            res.add(isHang ? matrix[index][from] : matrix[from][index]);
            int i = from > to ? from-- : from++;
        }
        res.add(isHang ? matrix[index][to] : matrix[to][index]);
        return res.size() >= matrixSize;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
