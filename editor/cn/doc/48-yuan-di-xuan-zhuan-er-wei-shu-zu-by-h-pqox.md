### 解题思路
把n分奇偶讨论，在二维数组中找到四个点旋转前后的坐标变换公式，i和j一定是在n/2附近结束
否则又把矩阵旋转回去了，然后分别用n=4和n=5的情况画图做辅助，找到i和j循环结束精确位置
即可结束本题。

### 代码

```java
class Solution {
    public void rotate(int[][] matrix){
        int n=matrix.length;
        if(n%2==1) {
            for (int i = 0; i < n / 2 + 1; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int temp1 = matrix[j][n - i - 1];
                    matrix[j][n - i - 1] = matrix[i][j];
                    int temp2 = matrix[n - i - 1][n - j - 1];
                    matrix[n - i - 1][n - j - 1] = temp1;
                    int temp3 = matrix[n - j - 1][i];
                    matrix[n - j - 1][i] = temp2;
                    matrix[i][j] = temp3;
                }
            }
        }
        else{
            for (int i = 0; i < n / 2 ; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int temp1 = matrix[j][n - i - 1];
                    matrix[j][n - i - 1] = matrix[i][j];
                    int temp2 = matrix[n - i - 1][n - j - 1];
                    matrix[n - i - 1][n - j - 1] = temp1;
                    int temp3 = matrix[n - j - 1][i];
                    matrix[n - j - 1][i] = temp2;
                    matrix[i][j] = temp3;
                }
            }
        }
    }
}
```