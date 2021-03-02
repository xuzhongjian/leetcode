//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 801 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean exist(char[][] board, String word) {

        boolean[][] markMap = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (exist(board, markMap, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param board   字符板
     * @param markMap 已经作为起点经历过的
     * @param index1  index
     * @param index2  index
     * @param i       字符的位置
     * @param word    单词
     * @return
     */
    public boolean exist(char[][] board, boolean[][] markMap, int index1, int index2, int i, String word) {
        // 单词跑完了
        if (i == word.length()) {
            return true;
        }
        // 单词还剩下没跑完
        // 前四个条件表示，当前这个点已经出界了
        // 第五个条件表示，当前这个点，倒着找回来了，直接false
        // 最后一个条件，当前这个字符要和word.get(i)相匹配
        if (index1 < 0 || index1 >= board.length || index2 < 0 || index2 >= board[0].length
                || markMap[index1][index2]
                || board[index1][index2] != word.charAt(i)) {
            return false;
        }
        markMap[index1][index2] = true;
        boolean res = exist(board, markMap, index1 + 1, index2, i + 1, word) ||
                exist(board, markMap, index1 - 1, index2, i + 1, word) ||
                exist(board, markMap, index1, index2 + 1, i + 1, word) ||
                exist(board, markMap, index1, index2 - 1, i + 1, word);
        markMap[index1][index2] = false;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
