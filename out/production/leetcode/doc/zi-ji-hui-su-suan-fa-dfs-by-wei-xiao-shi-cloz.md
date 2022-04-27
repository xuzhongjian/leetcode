### 解题思路

    新建一个res队列，用来存储返回的子集的集合（即为答案）；
    新建一个path队列，用来存储各种符合条件的子集（[],[1],[1,2],[1,2,3]等）；
这是回溯算法的惯用套路。


![E2C55933-0D86-4F8E-82B9-430682B5B099.png](https://pic.leetcode-cn.com/1613704529-qfwaRN-E2C55933-0D86-4F8E-82B9-430682B5B099.png)

    len表示nums数组的长度，同时也为树的高度
    每次到一个层，选择是否将该层的数nums[level]加入
我们每到一层都可以不选择或者选择当前层的数字，经过这样的遍历，所有可能的子集都出现在叶子结点上，因此我们将叶子结点上的结果加入res中；

### 代码

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();

        dfs(nums,len,0,res,path);

        return res;
    }

    private void dfs(int[] nums,int len,int level,List<List<Integer>> res,Deque<Integer> path){
        if (level==len){
            res.add(new ArrayList<>(path));
            return;
        }

            dfs(nums,len,level+1,res,path);//不选当前数；
            //选当前数；
            path.add(nums[level]);
            dfs(nums,len,level+1,res,path);
            path.removeLast();
    }
}
```