### 解题思路
此处撰写解题思路
    把二维数组看作是图，首先两个for循环遍历数组中的字母，选择其中等于字符串第一个字母的位置作为起始位置。
        ['A','B','C','E']
        ['S','F','C','S']
        ['A','D','E','E']
若String word = “ABCCED”，则应选取A作为起始位置的坐标（图中有0，0和2，0）；
    used[][]数组用来标记走过的路径，走过的路径不能再走；
    i,j用来标记当前走到的位置；
如果当前在（i，j），则向左走一步为（i，j-1），向右走一步为（i，j+1），向上走一步为（i-1，j），向下走一步为（i+1，j）；
每走过一个位置都要将used[i][j]置1，表示走过了；每回退一步都要将used[i][j]置0，表示没走了；
    index下标用来指示word字符串中已经走完了那些字母，当走完最后一个时，即index==word.length()，表示找到了一条完整的路；

### 代码

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;            //获取行数；
        int col = board[0].length;         //获取列数；

        int[][] used = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j]==word.charAt(0)) {
                    used[i][j]=1;
                    if (bfs(board, row, col, i, j, 1,word,used))
                        return true;
                    used[i][j]=0;
                }
            }
        }
        return false;
    }

    private static boolean bfs(char[][] board,int row,int col,int i ,int j,int index,String word,int[][] used){
        if (index==word.length()){
            return true;

        }

        //向左走一步
        if (0<=i && i<row && 1<=j && j<col && board[i][j-1]==word.charAt(index) && used[i][j-1]!=1){
            used[i][j-1]=1;
            if (bfs(board, row, col, i, j-1, index+1, word,used))
                return true;
            used[i][j-1]=0;
        }

        //向右走一步
        if (0<=i && i<row && 0<=j && j<col-1 && board[i][j+1]==word.charAt(index) && used[i][j+1]!=1){

            used[i][j+1]=1;
            if (bfs(board, row, col, i, j + 1, index + 1,word,used))
                return true;
            used[i][j+1]=0;
        }

        //向上走一步
        if (1<=i && i<row && 0<=j && j<col && board[i-1][j]==word.charAt(index) && used[i-1][j]!=1) {
           
            used[i-1][j]=1;
            if (bfs(board, row, col, i - 1, j, index + 1, word,used))
                return true;
            used[i-1][j]=0;
        }

        //向下走一步
        if (0<=i && i<row-1 && 0<=j && j<col && board[i+1][j]==word.charAt(index) && used[i+1][j]!=1) {
         
            used[i+1][j]=1;
            if (bfs(board, row, col, i + 1, j, index + 1,word,used))
                return true;
            used[i+1][j]=0;
        }

        return false;
    }
}



```