## DFS + 回溯解法

这道题和 [39. 组合总和（中等）](https://mp.weixin.qq.com/s/5Ee6jbc3lDlWFEDzTM_LkA) 几乎一样。

唯一的不同是这题每个数只能使用一次，而「39. 组合总和（中等）」中可以使用无限次。

我们再来回顾一下应该如何快速判断一道题是否应该使用 DFS + 回溯算法来爆搜。

这个判断方法，最早三叶在 [37. 解数独（困难）](https://mp.weixin.qq.com/s/0y4lGAH43U3w5loTgaeyoQ) 讲过。

总的来说，你可以从两个方面来考虑：

  * *1. 求的是所有的方案，而不是方案数。* 由于求的是所有方案，不可能有什么特别的优化，我们只能进行枚举。这时候可能的解法有动态规划、记忆化搜索、DFS + 回溯算法。

  * *2. 通常数据范围不会太大，只有几十。* 如果是动态规划或是记忆化搜索的题的话，由于它们的特点在于低重复/不重复枚举，所以一般数据范围可以出到 *10^5* 到 *10^7*，而 DFS + 回溯的话，通常会限制在 30 以内。
  
这道题数据范围是 30 以内，而且是求所有方案。因此我们使用 DFS + 回溯来求解。


我们可以接着 [39. 组合总和（中等）](https://mp.weixin.qq.com/s/5Ee6jbc3lDlWFEDzTM_LkA) 的思路来修改：

1. 由于每个数字只能使用一次，我们可以直接在 DFS 中决策某个数是用还是不用。

2. 由于不允许重复答案，可以使用 set 来保存所有合法方案，最终再转为 list 进行返回。当然我们需要先对 cs 进行排序，确保得到的合法方案中数值都是从小到大的。这样 set 才能起到去重的作用。对于 `[1,2,1]` 和 `[1,1,2]`，set 不会认为是相同的数组。

```Java
class Solution {
    public List<List<Integer>> combinationSum2(int[] cs, int t) {
        Arrays.sort(cs);
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        dfs(cs, t, 0, ans, cur);
        return new ArrayList<>(ans);
    }

    /**
     * cs: 原数组，从该数组进行选数
     * t: 还剩多少值需要凑成。起始值为 target ，代表还没选择任何数；当 t = 0，代表选择的数凑成了 target
     * u: 当前决策到 cs[] 中的第几位
     * ans: 最终结果集
     * cur: 当前结果集
     */
    void dfs(int[] cs, int t, int u, Set<List<Integer>> ans, List<Integer> cur) {
        if (t == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        if (u == cs.length || t < 0) return;

        // 使用 cs[u]
        cur.add(cs[u]);
        dfs(cs, t - cs[u], u + 1, ans, cur);

        // 进行回溯
        cur.remove(cur.size() - 1);
        // 不使用 cs[u]
        dfs(cs, t, u + 1, ans, cur);
    }
}
```
* 时间复杂度： DFS 回溯算法通常是指数级别的复杂度（因此数据范围通常为 30 以内）。这里暂定 *O(n * 2^n)*
* 空间复杂度：同上。复杂度为 *O(n * 2^n)*

*** 

## 最后

如果有帮助到你，请给个点赞关注，让更多的人看到 ~ ("▔□▔)/

也欢迎你 [关注我](http://wechat.peterxx.com/qr_code_promote.html) 和 加入我们的[「组队打卡」](https://leetcode-cn.com/u/ac_oier/)小群 ，提供写「证明」&「思路」的高质量题解 