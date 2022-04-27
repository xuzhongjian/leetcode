
// 思路： 带记忆化的递归，枚举各个节点作为顶点，然后左右两边分别递归得到左右子树的的搜索树种类，相乘即可得到当前节点作为跟的搜索树种类，然后将所有的枚举相加即为所求结果，但是区间每次都重复计算了，我们可以用一个二位数组记录下来所求得的区间结果，每次判断区间结果是否以及计算过了，若计算过直接返回结果即可。
 

```
class Solution {
    int[][] res;
    public int numTrees(int n) {
        res = new int[n + 1][n + 1];
        for(int i = 0;i <= n;i++){
            int[] row = res[i];
            Arrays.fill(row,-1);
        }
        return dfs(1,n);
    }
    public int dfs(int L, int R){
        if(L >= R){return 1;}
        if(res[L][R] != -1){return res[L][R];}  //计算过直接返回结果
        int sum = 0;
        for(int i = L;i <= R;i++){
            sum += dfs(L,i - 1) * dfs(i + 1,R); // 求出区间[L,R]的种类
        }
        res[L][R] = sum;  记录结果
        return sum;
    }
}
```
