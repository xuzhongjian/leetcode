### 解题思路
1、先根据总长度计算出边长side；
2、有a b c d四条边，每根火柴都可以选择任意位置放置；
3、先放第0根，四种放置方法，再放第1根，也是四中放置方法，也就是有4的n次方的放置方法。
4、只需要遍历出所有放置方法就能找出正确的结果

### 代码原始版本

```java
class Solution {
    public boolean makesquare(int[] nums) {
        if (null == nums || nums.length < 4) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        if (sum % 4 != 0) {
            return false;
        }

        return dfs(nums, 0, 0, 0, 0, 0, sum / 4);
    }

    /**
     * 
     * @param nums
     * @param index 表示当前放置到了第几个元素
     * @param a|b|c|d表示四个边长
     * @param side 表示最终的边长
     */
    private boolean dfs(int[] nums, int index, int a, int b, int c, int d, int side) {
        if (index == nums.length) {
            return a == side && b == side && c == side && d == side;
        }
        
        if (a > side || b > side || c > side || d > side) {
            // 只要有一个边大于边长，则不用进行下一步放置了
            return false;
        }

        // 每根火柴都有四种放置地点；分别将index位置的火柴放到a b c d四个位置，检查是否成功
        return dfs(nums, index + 1, a + nums[index], b, c, d, side)
            || dfs(nums, index + 1, a, b + nums[index], c, d, side)
            || dfs(nums, index + 1, a, b, c + nums[index], d, side)
            || dfs(nums, index + 1, a, b, c, d + nums[index], side);
    }
}
```


### 代码优化版1

```java
class Solution {
    public boolean makesquare(int[] nums) {
        if (null == nums || nums.length < 4) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        int side = sum / 4;
        if (side * 4 != sum) {
            // 如果sum不能被4整除，说明肯定组不了正方形
            return false;
        }

        return dfs2(nums, 0, 0, 0, 0, 0, side);
    }

    private boolean dfs2(int[] nums, int index, int a, int b, int c, int d, int side) {
        if (index == nums.length) {
            return a == side && b == side && c == side && d == side;
        }
        
        if (a > side || b > side || c > side || d > side) {
            // 只要有一个边大于边长，则不用进行下一步放置了
            return false;
        }

        // 假设a b两条边是一样长的，那把index放到a或者放到b的结果一样，所以这边加个set去重剪枝。
        Set<Integer> set = new HashSet<>();
        boolean res = false;
        if (!set.contains(a)) {
            res = res || dfs2(nums, index + 1, a + nums[index], b, c, d, side);
            set.add(a);
        }

        if (!set.contains(b)) {
            res = res || dfs2(nums, index + 1, a, b + nums[index], c, d, side);
            set.add(b);
        }

        if (!set.contains(c)) {
            res = res || dfs2(nums, index + 1, a, b, c + nums[index], d, side);
            set.add(c);
        }

        if (!set.contains(d)) {
            res = res || dfs2(nums, index + 1, a, b, c, d + nums[index], side);
            set.add(d);
        }

        return res;
    }
}
```
