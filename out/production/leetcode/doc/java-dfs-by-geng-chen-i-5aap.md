```
class Solution {
    int max=0;
    public int maximalSquare(char[][] matrix) {
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]=='1') {
                    max=Math.max(1,max);
                    dfs(matrix,i+1,j+1,i,j);
                }
            }
        }
        return max*max;
    }
    private void dfs(char[][] matrix,int x,int y,int startX,int startY){
        if (x>matrix.length-1 || y>matrix[0].length-1 || matrix[x][y]=='0') return;
        for (int i=x;i>=startX;i--){
            if (matrix[i][y]=='0') return;
        }
        for (int i=y;i>=startY;i--){
            if (matrix[x][i]=='0') return;
        }
        max=Math.max(max,x-startX+1);
        dfs(matrix,x+1,y+1,startX,startY);
    }
}
```
