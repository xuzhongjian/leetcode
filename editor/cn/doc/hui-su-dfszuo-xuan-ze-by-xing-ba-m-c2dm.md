### 解题思路
题目要凑出四条边，用到所有的火柴，肯定要遍历，故可以递归（类似树的遍历）。
![img1.jpg](https://pic.leetcode-cn.com/1615013641-eKtNIi-img1.jpg)
总之遇到需要遍历的题目，不管是排列还是火柴棒，如果都是要做出选择，则首先应当考虑怎样做出选择
- 从终止条件思考：边要有四个，火柴也要全部用完，都有终止条件！！！也可以想到要递归
- 回溯的思想：从要做选择，到底是边选择火柴，还是火柴选择边。--->也就是递归的终止条件是遍历完了所有的边，还是遍历完了所有的火柴。
两种方法：
- 如果是dfs（4条边），先凑一条边（for所有的火柴），也就是边选择火柴，可以用vis[i]来记录每条边是否被用到，但最后要判断是不是所有的边都被用到（用target/4）。

- 如果是travel(所有的火柴)，火柴选择边，则对于每个火柴，我们都可以选择四条边（for四条边），并且此时应该想办法剪枝。

### 代码

```java
class Solution {
    int [] cnt;
    public boolean makesquare(int[] nums) {
        int  total=0;
        for(int num:nums){
            total+=num;
        }
        if(total==0||total%4!=0) return false;
//进行从小到大的排序
        Arrays.sort(nums);
        cnt=new int[4];
        return traver(nums.length-1,nums,total/4);
        
    }
    boolean traver(int index ,int []nums, int target){
  if(index==-1){
//全部用到
      if(cnt[0]==cnt[1]&&cnt[1]==cnt[2]&&cnt[2]==cnt[3]) return true;
return false;
  }

  for(int i=0;i<4;i++){
      //加上(i>0&&cnt[i]==cnt[i-1])剪枝，，，
    if(cnt[i]+nums[index]>target||(i>0&&cnt[i]==cnt[i-1]))continue;
    cnt[i]+=nums[index];
    if(traver(index-1,nums,target)) return true;
    cnt[i]-=nums[index];
  }
    return false;
    }}
```
如果没有剪枝是会很复杂的，比如第二种办法。



