![WX20210413-084236@2x.png](https://pic.leetcode-cn.com/1618274573-gTRDVf-WX20210413-084236@2x.png)


### 解题思路
本质上是用动态规划解决，但是得先明白一个基本的规律（或者叫推论）
- 对于已经是升序的整除子集[a,b,c]，如果有个更大的d出现，如果满足 d\%c==0,那么就可以构成 [a,b,c,d]

思路演进
- 基于上面规律，我们就可以基于更小的子集构建更大的子集，那么我们动态规划实现就是从左到右
- 自然为了能满足这个判断，我们还需要做升序的排列

动态规划
- 定义
d[i]表示到序号i的且包含nums[i]的时候最大子集

- 初始化
d[i]默认都是空的数组

- 计算
    - 对于i， 遍历 [0,i-1]的范围去找到里面能满足 d%c==0的最大的子集的数组arr
    - d[i]加上arr 还有 nums[i]

- 结果
最后针对[0,n-1]遍历d[i]找到最大子集就是结果

### 代码

```cpp
class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        int n = nums.size();
        if (n <= 0)
        {
            return vector<int>();
        }
        vector<vector<int>> d(n, vector<int>());

        // 非常重要的排序步骤
        sort(nums.begin(), nums.end());
    
        // 它会一直记录最大的子集size: 注意这里的坑是需要使用0，避免和size比较时候转换为一个极大的正整数
        int maxSize = 0;
        int maxSizeIndex = -1;
        
        for (int i = 0; i < n; ++i)
        {
            int currMaxSize = 0;
            int currMaxIndex = -1;
            for (int j = 0; j < i; ++j)
            {
                if (((nums[i] % nums[j]) == 0) && (currMaxSize < d[j].size()))
                {
                    currMaxSize = d[j].size();
                    currMaxIndex = j;
                }
            }
            if (currMaxIndex >= 0)
            {
                d[i].insert(d[i].end(), d[currMaxIndex].begin(), d[currMaxIndex].end());
            }
            d[i].push_back(nums[i]);
            // cout << currMaxIndex << " " << maxSize << " vs " << d[i].size() << " i " << i << endl;
            // 记录最大的子集
            if (maxSize < d[i].size())
            {
                maxSize = d[i].size();
                maxSizeIndex = i;
            }
        }
        return d[maxSizeIndex];
    }
};
```