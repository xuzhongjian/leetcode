//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 
//
// 上图是一个部分填充的有效的数独。 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 示例 1: 
//
// 输入:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 
//
// 说明: 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 给定数独序列只包含数字 1-9 和字符 '.' 。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 
// 👍 481 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 0 3 6
        for (int i = 0; i < 7; i += 3) {
            for (int j = 0; j < 7; j += 3) {
                if (!isVaild33(board, i, j)) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!isVaildLine(board, i, true)) {
                return false;
            }
            if (!isVaildLine(board, i, false)) {
                return false;
            }
        }
        return true;
    }

    public boolean isVaildLine(char[][] board, int index, boolean isIndex1) {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(isIndex1 ? board[index][i] : board[i][index]);
        }
        return this.isVaild(list);
    }

    public boolean isVaild33(char[][] board, int index1, int index2) {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = index1; i < index1 + 3; i++) {
            for (int j = index2; j < index2 + 3; j++) {
                list.add(board[i][j]);
            }
        }
        return this.isVaild(list);
    }

    private boolean isVaild(List<Character> list) {
        Set<Character> set = new HashSet<>();
        for (Character c : list) {
            if (c == '.') {
                continue;
            }
            if (set.contains(c)) {
                return false;
            } else {
                set.add(c);
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
